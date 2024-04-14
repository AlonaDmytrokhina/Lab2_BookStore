import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BooksWarehouse {

    private String name;
    ArrayList<Genre> genres;

    /**
     *
     * @param name
     */
    BooksWarehouse(String name){
        this.name = name;
        this.genres = new ArrayList<>();
    }

    public String getName() {return name;}
    public int getNGenres() {return this.genres.size();}
    public ArrayList<Genre> getGenres() {return genres;}
    public void setName(String name) {this.name = name;}

//Метод для знаходження жанру за ім'ям
    public Genre findGenre(String name){
        for(int i=0; i<this.genres.size(); i++){
            if(this.genres.get(i).getName().equals(name)){
                return this.genres.get(i);
            }
        }
        return null;
    }

//Додавання жанру
    public void addGenre(Genre genre){
        this.genres.add(genre);
    }

// Видалення жанру
    public void deleteGenre(Genre genre){
        this.genres.remove(genre);
    }

//Метод для знаходження книги за ім'ям
    public Book findBook(String name){
        for(int i=0; i<this.genres.size(); i++){
            if(this.genres.get(i).findBook(name)!=null){
                return this.genres.get(i).findBook(name);
            }
        }
        return  null;
    }

//Поверненн всіх книг жанру
    public ArrayList<Book> getGenreBooks(Genre genre){
        return genre.getBooks();
    }

// Знаходження жанру за книгою
    public Genre findBookGenre(Book book){
        for(int i=0; i< genres.size(); i++){
            if(genres.get(i).findBook(book.getName())!=null){
                return genres.get(i);
            }
        }
        return null;
    }

//Поверненн всіх книг
    public ArrayList<Book> getAllBooks(){
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < genres.size(); i++) {
            for (int j = 0; j < genres.get(i).getNBooks(); j++) {
                books.add(genres.get(i).getBooks().get(j));
            }
        }
        return books;
    }

//Метод для запису назв жанрів у файл
    public void genresToFile(){
        String res = "";

        res += "\tПерелік категорій";
        for(int i=0; i<genres.size(); i++){
            res += "\n"+(i+1)+". "+genres.get(i).getName();
        }

        File genresFile = new File("Categories.txt");
        if (!genresFile.exists()) {
            try {
                genresFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(genresFile))) {
            bw.write(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}