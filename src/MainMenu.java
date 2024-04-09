import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class MainMenu extends JFrame {
    private JPanel groupPanel, productPanel, controlPanel;
    private JList<String> groupList;
    private JList<String> productList;
    DefaultListModel<String> listModel = new DefaultListModel<>();
    private JButton addGroupButton, editGroupButton, deleteGroupButton;
    private JButton addProductButton, editProductButton, deleteProductButton, viewDescriptionButton;
    private JTextField groupNameField, productNameField;
    private JTextField productManufacturerField, productQuantityField, productPriceField;
    private JButton addStockButton, removeStockButton, changePrice;
    private JTextField searchField;
    private JButton viewStatisticsButton, searchBook;
    private BooksWarehouse booksWarehouse = new BooksWarehouse("Book worm");
    private Genre choosedGenre;
    private Book choosedBook;


    public MainMenu() {
        setTitle("Система управління складом");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        groupNameField = new JTextField(10);
        productNameField = new JTextField(10);
        productManufacturerField = new JTextField(10);
        productQuantityField = new JTextField(10);
        productPriceField = new JTextField(10);
        searchField = new JTextField(10);
        addStockButton = new JButton("Додати товар на склад");
        removeStockButton = new JButton("Cписати товар зі складу");
        viewStatisticsButton = new JButton("Переглянути статистику");
        changePrice = new JButton("Змінити ціну");
        searchBook = new JButton("Шукати книгу");

        controlPanel.add(new JLabel("Назва категорії:"));
        controlPanel.add(groupNameField);
        controlPanel.add(new JLabel("Назва товару:"));
        controlPanel.add(productNameField);
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
    }

    private void defaultGenres() throws IOException {
        Detective det = new Detective();
        det.defaultBooks(booksWarehouse);

        UkrainianClassics ukrC = new UkrainianClassics();
        ukrC.defaultBooks(booksWarehouse);
    }

    private void addButtonGenres() {
        for (int i = 0; i < booksWarehouse.getNGenres(); i++) {
            listModel.addElement(booksWarehouse.getGenres().get(i).getName());
        }
        groupList.setModel(listModel);
    }

    // Метод для обробки події натискання на елемент категорії
    private void handleCategorySelection() {
        String selectedCategory = groupList.getSelectedValue();
        if (selectedCategory != null) {
            choosedGenre = booksWarehouse.findGenre(selectedCategory);
            // Отримати список товарів для вибраної категорії та відобразити його у списку товарів
            displayProductsForCategory();
            deleteGenre(choosedGenre);

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
        // Отримати список товарів для вибраної категорії та відобразити їх у списку товарів
        List<Book> products = booksWarehouse.getGenreBooks(choosedGenre);
        DefaultListModel<String> productListModel = new DefaultListModel<>();
        for (Book product : products) {
            // Додайте назву товару до списку товарів
            productListModel.addElement(product.getName());
        }
        productList.setModel(productListModel);
    }

    private void handleProductSelection() {
        String selectedProduct = productList.getSelectedValue();
        if (selectedProduct != null) {
            choosedBook = choosedGenre.findBook(selectedProduct);

            deleteProductButton.setEnabled(true);
            editProductButton.setEnabled(true);
            viewDescriptionButton.setEnabled(true);

            showBookInformatoin();
        }
    }

    private void addGenre(){
        addGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void editGenre(){
        editGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void deleteGenre(Genre genre){
        deleteGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(genre != null) {
                    JFrame frame = new JFrame();
                    DeleteGenre deleteGenre = new DeleteGenre(frame, booksWarehouse, genre, groupList, productList);
                    deleteGenre.setVisible(true);

                    groupNameField.setText("");
                    productNameField.setText("");
                    productManufacturerField.setText("");
                    productQuantityField.setText("");
                    productPriceField.setText("");
                }
            }
        });
    }

    private void addBook(){
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void editBook(){
        editProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void deleteBook(){
        deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void viewDescription(){
        viewDescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void showBookInformatoin(){
        groupNameField.setText(choosedGenre.getName());
        productNameField.setText(choosedBook.getName());
        productManufacturerField.setText(choosedBook.getProducer());
        productQuantityField.setText(String.valueOf(choosedBook.getAmount()));
        productPriceField.setText(String.valueOf(choosedBook.getCost()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenu wms = new MainMenu();
            wms.setVisible(true);
        });
    }
}
