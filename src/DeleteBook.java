import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteBook extends JDialog {
    public DeleteBook(JFrame parent, Genre genre, Book book, JList<String> productList) {
        super(parent, "Підтверджуєте видалення?", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Чи підтверджуєте ви видалення товару \""+book.getName()+"\"?");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton yesButton = new JButton("Так");
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                genre.deleteBook(book);
                genre.toFile();
                DefaultListModel<String> model = (DefaultListModel<String>) productList.getModel();
                int selectedIndex = productList.getSelectedIndex();
                if (selectedIndex != -1) {
                    model.remove(selectedIndex);
                }

                dispose();
            }
        });

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
