
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PanelBooks {

    DefaultListModel<String> listModel = new DefaultListModel<>();
    JList<String> booksList = new JList<>(listModel);
    public void addPanelBooks(Genre genre, JPanel panel){
        for (int i=0; i<genre.getNBooks(); i++){
            listModel.add(i, genre.getBooks().get(i).getName());
        }
        panel.add(booksList);
        panel.add(new JScrollPane(booksList));

        booksList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {



                }
            }
        });
    }

    public void deletePannelBooks(Genre genre, JPanel panel){
        for (int i=0; i<genre.getNBooks(); i++){
            if(genre.getBooks().get(i) != null) {
                listModel.remove(i);
            }
        }
    }
}
