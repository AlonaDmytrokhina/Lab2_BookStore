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
    BooksWarehouse booksWarehouse;

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
        booksWarehouse = new BooksWarehouse("Book worm");
        String path1 = "Detective.txt";
        Genre detective = new Genre("Детектив", "ounijo", path1);

        String nameDet1 = "Чорнильне серце";
        String authorDet1 = "Роберт Галбрейт";
        String infoDet1 = "Коли до офісу детективів приходить перелякана Еді Ледвелл, благаючи про розмову з Робін Еллакотт, " +
                "\n\tприватна розслідувачка не знає, що й думати. Еді, співавторку популярного коміксу «Чорнильно-чорне серце», " +
                "\n\tпереслідує таємнича особа з інтернету, що називає себе Аномія. Еді конче треба дізнатися, хто ця людина. " +
                "\n\tРобін вирішує, що у такій справі агенція допомогти не може — і більше не згадує про цей випадок, " +
                "\n\tаж поки за кілька днів не надходить шокуюча новина: Еді викрали, використавши шокер, та вбили на Гайґейтському цвинтарі.";
        String producerDet1 = "КСД";
        int amountDet1 = 4;
        double costDet1 = 220;
        Book bookDet1 = new Book(nameDet1, authorDet1, infoDet1, producerDet1, amountDet1, costDet1);

        String nameDet2 = "Смерть на Нілі";
        String authorDet2 = "Агата Крісті";
        String infoDet2 = "Молодята Саймон і Ліннет Дойли вирушають у весільну подорож на пароплаві \"Карнак\". " +
                "\n\tЖаклін де Бельфор, давня подруга Ліннет, у якої та відбила коханого, вирішує своєю присутністю " +
                "\n\tзіпсувати їм медовий місяць. Одного ранку служниця знаходить місіс Дойл мертвою... " +
                "\n\tХтось вистрелив їй у голову, поки вона спала. На стіні біля вбитої лишається кривава буква \"Ж\". " +
                "\n\tОднак Жаклін має залізне алібі. У справу втручається відомий харизматичний детектив Еркюль Пуаро. " +
                "\n\tВиявляється, майже всі пасажири мали мотив для вбивства. Щось приховує чи не кожен із них, а кілька, " +
                "\n\tяк стає відомо, подорожують зі зброєю. То хто цей холоднокровний убивця, що не зупиняється на одному злочині? ";
        String producerDet2 = "Жорж";
        int amountDet2 = 2;
        double costDet2 = 620;
        Book bookDet2 = new Book(nameDet2, authorDet2, infoDet2, producerDet2, amountDet2, costDet2);

        detective.addBook(bookDet1);
        detective.addBook(bookDet2);
        detective.toFile();
        booksWarehouse.addGenre(detective);


        String path2 = "UkrainianClassics.txt";
        Genre ukrainianClassics = new Genre("Українська класика", "ounijo", path2);

        String nameUC1 = "Майстер корабля.Байгород";
        String authorUC1 = "Юрій Яновський";
        String infoUC1 = "Одеса, у яку прилітали тільки скажені шторми з моря. Українське кіно, свіже і сміливе," +
                "\n\tяк юнга на високій щоглі. Молоді люди, які шукають себе і знаходять — дружбу, кохання," +
                "\n\tвірність, мужність. Режисер, художник, балерина, матрос, одеські рибалки," +
                "\n\tпортові дівчата, директор кінофабрики, власник шхуни.";
        String producerUC1 = "Віхола";
        int amountUC1 = 6;
        double costUC1 = 320;
        Book bookUC1 = new Book(nameUC1, authorUC1, infoUC1, producerUC1, amountUC1, costUC1);

        String nameUC2 = "Маруся Богуславка";
        String authorUC2 = "Іван Багряний";
        String infoUC2 = "Роман «Маруся Богуславка» започаткував епопею «Буйний вітер», задуману" +
                "\n\tІ. Багряним як трилогія про українську молодь у передвоєнні й воєнні роки, яка," +
                "\n\tоднак, так і залишилася незавершеною.";
        String producerUC2 = "Folio";
        int amountUC2 = 2;
        double costUC2 = 343;
        Book bookUC2 = new Book(nameUC2, authorUC2, infoUC2, producerUC2, amountUC2, costUC2);

        ukrainianClassics.addBook(bookUC1);
        ukrainianClassics.addBook(bookUC2);
        ukrainianClassics.toFile();
        booksWarehouse.addGenre(ukrainianClassics);
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
