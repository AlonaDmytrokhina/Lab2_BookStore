import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Genre {
    private String name;
    private String info;
    ArrayList<Book> books;
    File file;
    private String path;

    /**
     *
     * @param name
     * @param info
     * @param path
     * @throws IOException
     */
    Genre(String name, String info, String path) throws IOException {
        this.name = name;
        this.info = info;
        this.books = new ArrayList<>();
        this.file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        this.path = path;
    }

//Методи для повернення значень полей
    public String getName() {return name;}
    public String getInfo() {return info;}
    public int getNBooks() {return this.books.size();}
    public ArrayList<Book> getBooks() {return books;}
    public String getPath() {return path;}

//    Методи для зміни значень полей
    public void setName(String name) {this.name = name;}
    public void setInfo(String info) {this.info = info;}

    public void toFile(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.file))) {
            bw.write(this.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    Знаходження книги за назвою
    public Book findBook(String name){
        for(int i=0; i<this.books.size(); i++){
            if(this.books.get(i).getName().equals(name)){
                return books.get(i);
            }
        }
        return null;
    }

//    Додавання книги
    public void addBook(Book book){
        this.books.add(book);
    }

//    Видалення книги
    public void deleteBook(Book book){
        this.books.remove(book);
    }

//    Метод для виведення
    public String toString(){
        String res = "";
        res += "\t"+this.name;
        res += "\n";
        for(int i=0; i<this.books.size(); i++){
            res += this.books.get(i).toString();
            res += "\n";
        }
        return  res;
    }
}