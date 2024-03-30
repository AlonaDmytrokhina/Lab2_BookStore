import java.util.Arrays;

public class Genre {
    private String name;
    private String info;
    private int nBooks;
    private Book[] books;

    Genre(String name, String info, int nBooks){
        this.name = name;
        this.info = info;
        this.nBooks = nBooks;
        this.books = new Book[nBooks];
    }

    public String getName() {return name;}

    public String getInfo() {return info;}

    public int getnBooks() {return nBooks;}

    public Book[] getBooks() {return books;}

    public void setName(String name) {this.name = name;}

    public void setInfo(String info) {this.info = info;}

    public void setBooks(Book[] books) {this.books = books;}

    public Book findBook(String name){
        for(int i=0; i<this.nBooks; i++){
            if(this.books[i].getName()==name){
                return books[i];
            }
        }
        return null;
    }

    public void addBook(Book book){
        Book[] copy = Arrays.copyOf(this.books, this.nBooks + 1);
        copy[copy.length - 1] = book;
        this.nBooks++;
        this.books = copy;
    }

    public void deleteBook(Book book){
        for (int i=0; i<this.nBooks; i++) {
            if (books[i].getName() == book.getName()) {
                Book[] newArray = new Book[this.nBooks - 1];
                System.arraycopy(this.books, 0, newArray, 0, i);
                System.arraycopy(this.books, i + 1, newArray, i, newArray.length - i);
                this.nBooks--;
                this.books = newArray;
                break;
            }
        }
    }
}