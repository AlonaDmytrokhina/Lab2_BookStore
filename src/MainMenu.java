import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainMenu extends JFrame {
    private JPanel groupPanel, productPanel, controlPanel;
    private JTable groupTable, productTable;
    private JButton addGroupButton, editGroupButton, deleteGroupButton;
    private JButton addProductButton, editProductButton, deleteProductButton, viewDescriptionButton; // Додана кнопка для перегляду опису
    private JTextField groupNameField, productNameField;
    private JTextField productManufacturerField, productQuantityField, productPriceField;
    private JButton addStockButton, removeStockButton, changePrice;
    private JTextField searchField;
    private JButton viewStatisticsButton, searchBook;
    BooksWarehouse booksWarehouse = new BooksWarehouse("Book worm");;

    public MainMenu() {
        setTitle("Система управління складом");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 3));

        // Панель Групи
        groupPanel = new JPanel(new BorderLayout());
        groupPanel.setBorder(BorderFactory.createTitledBorder("Категорії"));
        groupTable = new JTable(new DefaultTableModel(new Object[]{"Назви категорій"}, 0));
        JScrollPane groupScrollPane = new JScrollPane(groupTable);
        groupPanel.add(groupScrollPane, BorderLayout.CENTER);
        groupPanel.setPreferredSize(new Dimension(100, 0)); // Зменшено розмір панелі категорій

        JPanel groupButtonPanel = new JPanel(new GridLayout(1, 3));
        addGroupButton = new JButton("Додати");
        editGroupButton = new JButton("Редагувати");
        deleteGroupButton = new JButton("Видалити");
        groupButtonPanel.add(addGroupButton);
        groupButtonPanel.add(editGroupButton);
        groupButtonPanel.add(deleteGroupButton);
        groupPanel.add(groupButtonPanel, BorderLayout.SOUTH);

        // Панель Товари
        productPanel = new JPanel(new BorderLayout());
        productPanel.setBorder(BorderFactory.createTitledBorder("Товари"));
        productTable = new JTable(new DefaultTableModel(new Object[]{" №", "Назва", "Видавництво", "К-сть", "Ціна"}, 0)); // Додано "Опис" до заголовків
        JScrollPane productScrollPane = new JScrollPane(productTable);
        productPanel.add(productScrollPane, BorderLayout.CENTER);
        productPanel.setPreferredSize(new Dimension(380, productPanel.getPreferredSize().height)); // Збільшено розмір панелі товарів

        JPanel productButtonPanel = new JPanel(new GridLayout(1, 4)); // Змінено на 4 кнопки
        addProductButton = new JButton("Додати");
        editProductButton = new JButton("Редагувати");
        deleteProductButton = new JButton("Видалити");
        viewDescriptionButton = new JButton("Опис"); // Додано кнопку для перегляду опису
        productButtonPanel.add(addProductButton);
        productButtonPanel.add(editProductButton);
        productButtonPanel.add(deleteProductButton);
        productButtonPanel.add(viewDescriptionButton); // Додано кнопку для перегляду опису
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
        controlPanel.add(Box.createVerticalStrut(5)); // Вставляємо вертикальну відстань 10 пікселів
        controlPanel.add(removeStockButton);
        controlPanel.add(Box.createVerticalStrut(20)); // Вставляємо вертикальну відстань 20 пікселів
        controlPanel.add(new JLabel("Ціна:"));
        controlPanel.add(productPriceField);
        controlPanel.add(Box.createVerticalStrut(30)); // Вставляємо вертикальну відстань 30 пікселів
        controlPanel.add(changePrice);
        controlPanel.add(new JLabel("Пошук:"));

        controlPanel.add(searchField);
        controlPanel.add(viewStatisticsButton);
        controlPanel.add(searchBook);


        controlPanel.setPreferredSize(new Dimension(200, controlPanel.getPreferredSize().height));

        defaultGenres();
        addButtonGenres();

        // Додавання панелей до вікна
        add(groupPanel);
        add(productPanel);
        add(controlPanel);

        pack();
        setLocationRelativeTo(null); // Центрувати вікно
    }

    private void defaultGenres(){
        Detective det = new Detective();
        det.defaultBooks(booksWarehouse);

        UkrainianClassics ukrC = new UkrainianClassics();
        ukrC.defaultBooks(booksWarehouse);
    }

    private void addButtonGenres(){
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> genresList = new JList<>(listModel);
        for (int i=0; i<booksWarehouse.getNGenres(); i++){
            listModel.add(i, booksWarehouse.getGenres().get(i).getName());
        }
        groupPanel.add(genresList);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenu wms = new MainMenu();
            wms.setVisible(true);
        });
    }
}
