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
    private JButton addStockButton, removeStockButton;
    private JTextField searchField;
    private JButton viewStatisticsButton, searchBook;

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
        controlPanel = new JPanel(new GridLayout(10, 1));
        controlPanel.setBorder(BorderFactory.createTitledBorder("Керування"));
        groupNameField = new JTextField(10);

        productNameField = new JTextField(10);
        productManufacturerField = new JTextField(10);
        productQuantityField = new JTextField(10);
        productPriceField = new JTextField(10);
        searchField = new JTextField(10);

        addStockButton = new JButton("Додати товар на склад");
        removeStockButton = new JButton("Видалити товар зі складу");
        viewStatisticsButton = new JButton("Переглянути статистику");
        searchBook = new JButton("Шукати книгу");

        controlPanel.add(new JLabel("Назва групи:"));
        controlPanel.add(groupNameField);

        controlPanel.add(new JLabel("Назва товару:"));
        controlPanel.add(productNameField);
        controlPanel.add(new JLabel("Виробник:"));
        controlPanel.add(productManufacturerField);
        controlPanel.add(new JLabel("Кількість:"));
        controlPanel.add(productQuantityField);
        controlPanel.add(new JLabel("Ціна:"));
        controlPanel.add(productPriceField);
        controlPanel.add(addStockButton);
        controlPanel.add(removeStockButton);
        controlPanel.add(new JLabel("Пошук:"));
        controlPanel.add(searchField);
        controlPanel.add(searchBook);
        controlPanel.add(viewStatisticsButton);
        controlPanel.setPreferredSize(new Dimension(200, controlPanel.getPreferredSize().height));

        // Додавання панелей до вікна
        add(groupPanel);
        add(productPanel);
        add(controlPanel);

        pack();
        setLocationRelativeTo(null); // Центрувати вікно
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenu wms = new MainMenu();
            wms.setVisible(true);
        });
    }
}
