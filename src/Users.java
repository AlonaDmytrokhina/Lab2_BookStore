import javax.swing.*;



public class Users extends JFrame {

    private JLabel loginLabel, passwordLabel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Users() {
        setTitle("Вхід "); //назва вікна
        setSize(500, 400); // розмір
        setDefaultCloseOperation(EXIT_ON_CLOSE);// закриття вікна
        setLocationRelativeTo(null); // розмістити по центру екрана
        setLayout(null);

        loginLabel = new JLabel("Логін:"); // текст про ввід логіну
        loginLabel.setBounds(140, 120, 80, 25); // розмір
        add(loginLabel);

        loginField = new JTextField(); //  для введення логіна
        loginField.setBounds(200, 120, 160, 25);// розмір
        add(loginField);

        passwordLabel = new JLabel("Пароль:"); // текст про ввід пароля
        passwordLabel.setBounds(140, 150, 80, 25); // розмір
        add(passwordLabel);

        passwordField = new JPasswordField(); // рядок для вводу пароля
        passwordField.setBounds(200, 150, 160, 25);//
        add(passwordField);

        loginButton = new JButton("Увійти"); // кнопочка для входу
        loginButton.setBounds(230, 200, 80, 25);//
        loginButton.addActionListener(e -> checkLogin()); // поія для перевірки правильності даних
        add(loginButton);
    }

    private void checkLogin() { // перевірка паролю та логіна
        String login = loginField.getText();
        String password = new String(passwordField.getPassword());

        // Перевірка паролю і логіну
        if (login.equals("3524") && password.equals("0000")) {
            JOptionPane.showMessageDialog(this, "Ви увійшли до бази складу", "Успішна авторизація", JOptionPane.INFORMATION_MESSAGE);
            openMainWindow(); // відкрити головне вікно
            dispose(); // закрити поточне вікно
        } else {
            JOptionPane.showMessageDialog(this, "Невірний логін або пароль "+ "\nСпробуйте ще раз", "Помилка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openMainWindow() { // відкрити головне вікно
        // Ваш код для відкриття головного вікна
        JFrame mainFrame = new JFrame("Головне меню");
        mainFrame.setSize(700, 550);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Users users = new Users();
            users.setVisible(true);
        });
    }
}

