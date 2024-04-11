import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends JFrame {
    private JPanel groupPanel, productPanel, controlPanel;
    private JList<String> groupList;
    private JList<String> productList;
    DefaultListModel<String> listModelCategories = new DefaultListModel<>();
    DefaultListModel<String> listModelBooks = new DefaultListModel<>();
    private JButton addGroupButton, editGroupButton, deleteGroupButton;
    private JButton addProductButton, editProductButton, deleteProductButton, viewDescriptionButton;
    private JTextField productNameField, productAuthorField;
    private JTextField productManufacturerField, productQuantityField, productPriceField;
    private JButton addStockButton, removeStockButton, changePrice;
    private JTextField searchField;
    private JButton viewStatisticsButton, searchBook;
    private BooksWarehouse booksWarehouse = new BooksWarehouse("Book worm");
    private Genre choosedGenre;
    private Book choosedBook;
    DeleteGenre deleteGenre;


    public MainMenu() {
        setTitle("Система управління складом");
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(1, 3));

        // Панель Групи
        groupPanel = new JPanel(new BorderLayout());
        groupPanel.setBorder(BorderFactory.createTitledBorder("Категорії"));
        DefaultListModel<String> groupListModel = new DefaultListModel<>();
        groupList = new JList<>(groupListModel);
        JScrollPane groupScrollPane = new JScrollPane(groupList);
        groupPanel.add(groupScrollPane, BorderLayout.CENTER);
        groupPanel.setPreferredSize(new Dimension(100, 0));

        JPanel groupButtonPanel = new JPanel(new GridLayout(1, 3));
        addGroupButton = new JButton("Додати");
        editGroupButton = new JButton("Редагувати");
        editGroupButton.setEnabled(false);
        deleteGroupButton = new JButton("Видалити");
        deleteGroupButton.setEnabled(false);
        groupButtonPanel.add(addGroupButton);
        groupButtonPanel.add(editGroupButton);
        groupButtonPanel.add(deleteGroupButton);
        groupPanel.add(groupButtonPanel, BorderLayout.SOUTH);

        // Панель Товари
        productPanel = new JPanel(new BorderLayout());
        productPanel.setBorder(BorderFactory.createTitledBorder("Товари"));
        DefaultListModel<String> productListModel = new DefaultListModel<>();
        productList = new JList<>(productListModel);
        JScrollPane productScrollPane = new JScrollPane(productList);
        productPanel.add(productScrollPane, BorderLayout.CENTER);

        JPanel productButtonPanel = new JPanel(new GridLayout(1, 4));
        addProductButton = new JButton("Додати");
        addProductButton.setEnabled(false);
        editProductButton = new JButton("Редагувати");
        editProductButton.setEnabled(false);
        deleteProductButton = new JButton("Видалити");
        deleteProductButton.setEnabled(false);
        viewDescriptionButton = new JButton("Опис");
        viewDescriptionButton.setEnabled(false);
        productButtonPanel.add(addProductButton);
        productButtonPanel.add(editProductButton);
        productButtonPanel.add(deleteProductButton);
        productButtonPanel.add(viewDescriptionButton);
        productPanel.add(productButtonPanel, BorderLayout.SOUTH);

        // Панель Керування
        controlPanel = new JPanel(new GridLayout(12, 1));
        controlPanel.setBorder(BorderFactory.createTitledBorder("Керування"));
        productNameField = new JTextField(10);
        productAuthorField = new JTextField(10);
        productManufacturerField = new JTextField(10);
        productQuantityField = new JTextField(10);
        productPriceField = new JTextField(10);
        searchField = new JTextField(10);
        addStockButton = new JButton("Додати товар на склад");
        increaseProduct();
        removeStockButton = new JButton("Cписати товар зі складу");
        reducingProduct();
        viewStatisticsButton = new JButton("Переглянути статистику");
        changePrice = new JButton("Змінити ціну");
        searchBook = new JButton("Шукати книгу");

        controlPanel.add(new JLabel("Назва товару:"));
        controlPanel.add(productNameField);
        controlPanel.add(new JLabel("Автор:"));
        controlPanel.add(productAuthorField);
        controlPanel.add(new JLabel("Видавництво:"));
        controlPanel.add(productManufacturerField);
        controlPanel.add(new JLabel("Кількість:"));
        controlPanel.add(productQuantityField);
        controlPanel.add(addStockButton);
        controlPanel.add(Box.createVerticalStrut(5));
        controlPanel.add(removeStockButton);
        controlPanel.add(Box.createVerticalStrut(20));
        controlPanel.add(new JLabel("Ціна:"));
        controlPanel.add(productPriceField);
        controlPanel.add(Box.createVerticalStrut(30));
        newPrice();
        controlPanel.add(changePrice);
        controlPanel.add(new JLabel("Пошук:"));
        controlPanel.add(searchField);
        controlPanel.add(viewStatisticsButton);
        controlPanel.add(searchBook);

        controlPanel.setPreferredSize(new Dimension(200, controlPanel.getPreferredSize().height));

        try {
            defaultGenres();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        addButtonGenres();

        // Додавання панелей до вікна
        add(groupPanel);
        add(productPanel);
        add(controlPanel);

        pack();
        setLocationRelativeTo(null);

        // Додайте слухача подій до списку категорій
        groupList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    handleCategorySelection();
                    deleteGroupButton.setEnabled(true);
                    editGroupButton.setEnabled(true);
                }
            }
        });
        addGenre();
        editGenre();
        deleteGenre();

        addBook();
        editBook();
        deleteBook();
        viewDescription();

        searchingBooks();
    }
    private void newPrice(){
        changePrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePrice();
            }
        });
    }
    private void changePrice() {
        String newPriceStr = JOptionPane.showInputDialog(MainMenu.this, "Введіть нову ціну:");
        try {
            double newPrice = Double.parseDouble(newPriceStr);
            if (newPrice > 0) {
                // Оновлення ціни вибраної книги
                if (choosedBook != null) {
                    booksWarehouse.findBook(choosedBook.getName()).setCost(newPrice);
                    booksWarehouse.findGenre(choosedGenre.getName()).toFile();

                    productPriceField.setText(String.valueOf(newPrice));
                }
            } else {
                JOptionPane.showMessageDialog(MainMenu.this, "Ціна повинна бути додатнім числом", "Помилка", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(MainMenu.this, "Будь ласка, введіть коректне число", "Помилка", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void defaultGenres() throws IOException {
        Detective det = new Detective();
        det.defaultBooks(booksWarehouse);

        UkrainianClassics ukrC = new UkrainianClassics();
        ukrC.defaultBooks(booksWarehouse);

        UkrainianModern ukrM= new UkrainianModern();
        ukrM.defaultBooks(booksWarehouse);

        Fantasy fant = new Fantasy();
        fant.defaultBooks(booksWarehouse);

        EnglishModern engM = new EnglishModern();
        engM.defaultBooks(booksWarehouse);
    }

    private void addButtonGenres() {
        for (int i = 0; i < booksWarehouse.getNGenres(); i++) {
            listModelCategories.addElement(booksWarehouse.getGenres().get(i).getName());
        }
        groupList.setModel(listModelCategories);
    }

    // Метод для обробки події натискання на елемент категорії
    private void handleCategorySelection() {
        String selectedCategory = groupList.getSelectedValue();
        if (selectedCategory != null) {
            choosedGenre = booksWarehouse.findGenre(selectedCategory);
            // Отримати список товарів для вибраної категорії та відобразити його у списку товарів
            displayProductsForCategory();
            clearButtons();

            addProductButton.setEnabled(true);
            productList.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        handleProductSelection();
                    }
                }
            });
        }
    }

    // Метод для відображення товарів для вибраної категорії
    private void displayProductsForCategory() {
        listModelBooks.clear();
        // Отримати список товарів для вибраної категорії та відобразити їх у списку товарів
        List<Book> products = booksWarehouse.getGenreBooks(choosedGenre);
        for (Book product : products) {
            // Додайте назву товару до списку товарів
            listModelBooks.addElement(product.getName());
        }
        productList.setModel(listModelBooks);
    }

    private void handleProductSelection() {
        String selectedProduct = productList.getSelectedValue();
        if (selectedProduct != null) {
            choosedBook = booksWarehouse.findBook(selectedProduct);
            if (choosedGenre==null){
                choosedGenre = booksWarehouse.findBookGenre(booksWarehouse.findBook(selectedProduct));
            }

            deleteProductButton.setEnabled(true);
            editProductButton.setEnabled(true);
            viewDescriptionButton.setEnabled(true);

            showBookInformation();
        }
    }

    private void addGenre(){
        addGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField genreNameField = new JTextField();
                JTextField filePathField = new JTextField();
                JPanel panel = new JPanel(new GridLayout(2, 2));
                panel.add(new JLabel("Назва категорії:"));
                panel.add(genreNameField);
                panel.add(new JLabel("Назва файлу:"));
                panel.add(filePathField);

                int result = JOptionPane.showConfirmDialog(MainMenu.this, panel, "Додати нову категорію", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    String newGenreName = genreNameField.getText();
                    String filePath = filePathField.getText()+".txt";
                    if (!newGenreName.isEmpty() && !filePath.isEmpty()) {
                        Genre newGenre;
                        try {
                            newGenre = new Genre(newGenreName,"...", filePath);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        booksWarehouse.addGenre(newGenre);
                        newGenre.toFile();
                        listModelCategories.addElement(newGenreName);
                        updateGenreList();
                    } else {
                        JOptionPane.showMessageDialog(MainMenu.this, "Будь ласка, введіть назву категорії та файлу", "Помилка", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    private void editGenre(){
        editGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newGenreName = JOptionPane.showInputDialog(MainMenu.this, "Введіть нову назву категорії:", choosedGenre.getName());
                if (newGenreName != null && !newGenreName.isEmpty()) {
                    booksWarehouse.findGenre(choosedGenre.getName()).setName(newGenreName);
                    booksWarehouse.findGenre(choosedGenre.getName()).toFile();
                    updateGenreList();
                }
            }
        });
    }

    private void updateGenreList() {
        listModelCategories.clear();
        for (Genre genre : booksWarehouse.getGenres()) {
            listModelCategories.addElement(genre.getName());
        }
    }

    private void deleteGenre(){
        deleteGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(booksWarehouse.findGenre(choosedGenre.getName()) != null) {
                    if(deleteGenre == null) {
                        JFrame frame = new JFrame();
                        deleteGenre = new DeleteGenre(frame, booksWarehouse, booksWarehouse.findGenre(choosedGenre.getName()), groupList, productList);
                    }
                    deleteGenre.setVisible(true);

                    if (booksWarehouse.findGenre(choosedGenre.getName())==null) {
                        deleteGenre = null;
                        clearButtons();
                    }
                }
            }
        });
    }

    private void addBook(){
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBook addBook = new AddBook(booksWarehouse, booksWarehouse.findGenre(choosedGenre.getName()), productList);
                addBook.setVisible(true);
            }
        });
    }

    private void editBookName() {
        JTextField nameField = new JTextField(choosedBook.getName());
        JTextField authorField = new JTextField(choosedBook.getAuthor());
        JTextField publisherField = new JTextField(choosedBook.getProducer());

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Назва товару:"));
        panel.add(nameField);
        panel.add(new JLabel("Автор:"));
        panel.add(authorField);
        panel.add(new JLabel("Видавництво:"));
        panel.add(publisherField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Редагувати товар", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String newName = nameField.getText().trim();
            String newAuthor = authorField.getText().trim();
            String newPublisher = publisherField.getText().trim();

            if (!newName.isEmpty() && !newAuthor.isEmpty() && !newPublisher.isEmpty()) {
                booksWarehouse.findBook(choosedBook.getName()).setName(newName);
                booksWarehouse.findGenre(choosedGenre.getName()).toFile();
                booksWarehouse.findBook(choosedBook.getName()).setAuthor(newAuthor);
                booksWarehouse.findGenre(choosedGenre.getName()).toFile();
                booksWarehouse.findBook(choosedBook.getName()).setProducer(newPublisher);
                booksWarehouse.findGenre(choosedGenre.getName()).toFile();

                productNameField.setText(newName);
                productAuthorField.setText(newAuthor);
                productManufacturerField.setText(newPublisher);

                displayProductsForCategory();
            } else {
                JOptionPane.showMessageDialog(null, "Будь ласка, заповніть всі поля", "Попередження", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void editBook(){
        editProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editBookName();
            }
        });

    }

    private void deleteBook(){
        deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(booksWarehouse.findGenre(choosedGenre.getName()) != null) {
                    JFrame frame = new JFrame();
                    DeleteBook deleteBook = new DeleteBook(frame, booksWarehouse.findGenre(choosedGenre.getName()), booksWarehouse.findBook(choosedBook.getName()), productList);
                    deleteBook.setVisible(true);

                    if (booksWarehouse.findBook(choosedBook.getName())==null) {
                        clearButtons();
                    }
                }
            }
        });
    }
    private void viewDescription(){
        viewDescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Отримати опис книги та вивести його у повідомленні
                if (booksWarehouse.findBook(choosedBook.getName()) != null) {
                    String description = choosedBook.getInfo();
                    JOptionPane.showMessageDialog(MainMenu.this, description, "Опис книги", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private void showBookInformation(){
        productNameField.setText(choosedBook.getName());
        productAuthorField.setText(choosedBook.getAuthor());
        productManufacturerField.setText(choosedBook.getProducer());
        productQuantityField.setText(String.valueOf(choosedBook.getAmount()));
        productPriceField.setText(String.valueOf(choosedBook.getCost()));

        productNameField.setEditable(false);
        productAuthorField.setEditable(false);
        productManufacturerField.setEditable(false);
        productQuantityField.setEditable(false);
        productPriceField.setEditable(false);
    }

    private void searchingBooks(){
        searchBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choosedGenre = null;
                choosedBook = null;
                listModelBooks.clear();
                clearButtons();
                List<Book> products = search(searchField.getText());
                for (Book product : products) {
                    listModelBooks.addElement(product.getName());
                }
                productList.setModel(listModelBooks);
                productList.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if (!e.getValueIsAdjusting()) {
                            handleProductSelection();
                        }
                    }
                });
            }
        });
    }

    private List<Book> search(String input){
        if (!input.equals("")) {
            List<Book> books = new ArrayList<>();
            List<Book> allBooks = booksWarehouse.getAllBooks(); // Отримати список книг тільки раз
            for (Book book : allBooks) {
                if (book.getName().toLowerCase().startsWith(input.toLowerCase())) {
                    books.add(book);
                }
            }
            return books;
        }
        return null;
    }

    private void clearButtons(){
        productNameField.setText("");
        productAuthorField.setText("");
        productManufacturerField.setText("");
        productQuantityField.setText("");
        productPriceField.setText("");

        productNameField.setEditable(false);
        productAuthorField.setEditable(false);
        productManufacturerField.setEditable(false);
        productQuantityField.setEditable(false);
        productPriceField.setEditable(false);
    }

    private void increaseProduct() {
        addStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String quantityStr = JOptionPane.showInputDialog(MainMenu.this, "Введіть кількість товару для додавання:");
                try {
                    int quantityToAdd = Integer.parseInt(quantityStr);
                    if (quantityToAdd > 0) {
                        // Додати кількість товару до тої що була
                        if (choosedBook != null) {
                            int currentQuan = choosedBook.getAmount();
                            booksWarehouse.findBook(choosedBook.getName()).setAmount(currentQuan + quantityToAdd);
                            booksWarehouse.findGenre(choosedGenre.getName()).toFile();
                            productQuantityField.setText(String.valueOf(choosedBook.getAmount()));
                        }
                    } else {
                        JOptionPane.showMessageDialog(MainMenu.this, "Кількість повинна бути більше нуля", "Помилка", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainMenu.this, "Введіть ціле число", "Помилка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    private void reducingProduct() {
        removeStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String quantityStr = JOptionPane.showInputDialog(MainMenu.this, "Введіть кількість товару для списання:");
                try {
                    int quantityToRemove = Integer.parseInt(quantityStr);
                    if (quantityToRemove > 0) {
                        // Відняти введену кількість товару від наявної
                        if (choosedBook != null) {
                            int currentQuantity = choosedBook.getAmount();
                            int newQuantity = currentQuantity - quantityToRemove;
                            // Перевірка на від'ємну кількість товару
                            if (newQuantity >= 0) {
                                booksWarehouse.findBook(choosedBook.getName()).setAmount(newQuantity);
                                booksWarehouse.findGenre(choosedGenre.getName()).toFile();
                                // Оновіть відображення кількості товару у вікні
                                productQuantityField.setText(String.valueOf(choosedBook.getAmount()));
                            } else {
                                JOptionPane.showMessageDialog(MainMenu.this, "Недостатня кількість товару на складі", "Помилка", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(MainMenu.this, "Кількість повинна бути більше нуля", "Помилка", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainMenu.this, "Будь ласка, введіть ціле число", "Помилка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenu wms = new MainMenu();
            wms.setVisible(true);
        });
    }
}
