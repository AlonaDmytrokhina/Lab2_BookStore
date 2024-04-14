import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteGenre extends JDialog {
    /**
     *
     * @param parent
     * @param booksWarehouse
     * @param genre
     * @param groupList
     * @param productList
     */
    public DeleteGenre(JFrame parent, BooksWarehouse booksWarehouse, Genre genre, JList<String> groupList, JList<String> productList) {
        super(parent, "Підтверджуєте видалення?", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Чи підтверджуєте ви видалення категорії \""+genre.getName()+"\"?");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

//Кнопка "Так", що реалізує видалення категорії
        JButton yesButton = new JButton("Так");
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = genre.getPath();

                // Створюємо об'єкт Path
                Path path = Paths.get(filePath);

                // Перевіряємо, чи файл існує перед видаленням
                if (Files.exists(path)) {
                    // Видаляємо файл
                    try {
                        Files.delete(path);
                    } catch (IOException el) {
                        JOptionPane.showMessageDialog(parent, "Виникла помилка: файл категорії не видалено.");
                    }
                } else {
                    JOptionPane.showMessageDialog(parent, "Файл не існує.");
                }
                booksWarehouse.deleteGenre(genre);
                booksWarehouse.genresToFile();
                DefaultListModel<String> model = (DefaultListModel<String>) groupList.getModel();
                int selectedIndex = groupList.getSelectedIndex();
                if (selectedIndex != -1) {
                    model.remove(selectedIndex);
                }

                DefaultListModel<String> modelB = (DefaultListModel<String>) productList.getModel();
                modelB.clear();

                dispose();
            }
        });
//        Кнопка "Ні" закриває вікно
        JButton noButton = new JButton("Ні");
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(label, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(parent);
    }
}
