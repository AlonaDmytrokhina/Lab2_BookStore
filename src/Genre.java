import java.util.ArrayList;
import java.util.Arrays;

public class Genre {
    private String name;
    private String info;
    ArrayList<Book> books;

    Genre(String name, String info){
        this.name = name;
        this.info = info;
        this.books = new ArrayList<>();
    }

    public String getName() {return name;}

    public String getInfo() {return info;}

    public int getNBooks() {return this.books.size();}

    public ArrayList<Book> getBooks() {return books;}

    public void setName(String name) {this.name = name;}

    public void setInfo(String info) {this.info = info;}

//    public void setBooks(Book[] books) {this.books = books;}

    public Book findBook(String name){
        for(int i=0; i<this.books.size(); i++){
            if(this.books.get(i).getName()==name){
                return books.get(i);
            }
        }
        return null;
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public void deleteBook(Book book){
        this.books.remove(book);
    }
}