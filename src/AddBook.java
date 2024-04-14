import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBook extends JFrame {

    private JPanel panel, buttonPanel;
    private JTextField productNameField, productAuthorField, productManufacturerField, productQuantityField, productCostField;
    private JButton descriptionButton, confirmDescription, saveButton;
    JFrame descriptionFrame;
    JTextArea descriptionArea;

    /**
     *
     * @param booksWarehouse
     * @param genre
     * @param productList
     */
    public AddBook(BooksWarehouse booksWarehouse, Genre genre, JList<String> productList){
        this.setTitle("Додати товар");
        this.setSize(700, 300);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(1, 2));
        this.setLocationRelativeTo(null);

        panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("Назва товару:"));
        productNameField = new JTextField();
        panel.add(productNameField);
        panel.add(new JLabel("Автор:"));
        productAuthorField = new JTextField();
        panel.add(productAuthorField);
        panel.add(new JLabel("Видавництво:"));
        productManufacturerField = new JTextField();
        panel.add(productManufacturerField);
        panel.add(new JLabel("Кількість:"));
        productQuantityField = new JTextField();
        panel.add(productQuantityField);
        panel.add(new JLabel("Ціна:"));
        productCostField = new JTextField();
        panel.add(productCostField);

        descriptionButton = new JButton("Ввести опис");
        descriptionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openDescriptionWindow();
            }
        });

        saveButton = new JButton("Зберегти");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveAll(genre, productList);
            }
        });

        panel.add(descriptionButton);
        panel.add(saveButton);

        this.add(panel);
    }

//    Метод для відкриття вікна для введення опису
    private void openDescriptionWindow() {
        descriptionFrame = new JFrame("Опис книги");
        descriptionFrame.setSize(400, 300);
        descriptionFrame.setLayout(new BorderLayout()); // Встановлюємо BorderLayout для вікна опису

        descriptionArea = new JTextArea();
        descriptionArea.setLineWrap(true); // Встановлює автоматичне перенесення тексту
        descriptionArea.setWrapStyleWord(true); // Перенос слова, а не просто символа
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 16 ));
        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        descriptionFrame.add(scrollPane, BorderLayout.CENTER); // Додаємо текстову область у центр

        buttonPanel = new JPanel(new FlowLayout()); // Панель для розміщення кнопки
        confirmDescription = new JButton("Зберегти");
        confirmDescription.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                descriptionFrame.dispose();
            }
        });
        buttonPanel.add(confirmDescription);
        descriptionFrame.add(buttonPanel, BorderLayout.SOUTH); // Додаємо панель з кнопкою у нижню частину

        descriptionFrame.setLocationRelativeTo(null);
        descriptionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        descriptionFrame.setVisible(true); // Робимо вікно опису видимим
    }

    /**
     *
     * @param genre
     * @param productList
     */
//    Метод для збереження всіх даних
    private void saveAll(Genre genre, JList<String> productList){
        try {
            String name = productNameField.getText();
            String author = productAuthorField.getText();
            String info = descriptionArea.getText();
            String producer = productManufacturerField.getText();
            int amount = Integer.parseInt(productQuantityField.getText());
            double cost = Double.parseDouble(productCostField.getText());

            // Перевірка на коректність введених даних
            if (name.isEmpty() || author.isEmpty() || info.isEmpty() || producer.isEmpty()) {
                throw new IllegalArgumentException("Будь ласка, заповніть всі поля.");
            }
            if (amount <= 0 || cost <= 0) {
                throw new IllegalArgumentException("Кількість та ціна повинні бути більшими за нуль.");
            }

            Book book = new Book(name, author, info, producer, amount, cost);
            genre.addBook(book);
            genre.toFile();

            DefaultListModel<String> model = (DefaultListModel<String>) productList.getModel();
            model.addElement(book.getName());

            this.dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Будь ласка, введіть коректні числові значення.", "Помилка", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Помилка", JOptionPane.ERROR_MESSAGE);
        }
    }


}
