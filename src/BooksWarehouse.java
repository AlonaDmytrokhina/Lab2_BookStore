import java.util.ArrayList;
import java.util.Arrays;

public class BooksWarehouse {

    private String name;
    ArrayList<Genre> genres;

    BooksWarehouse(String name){
        this.name = name;
        this.genres = new ArrayList<>();
    }

    public String getName() {return name;}
    public int getNGenres() {return this.genres.size();}
    public ArrayList<Genre> getGenres() {return genres;}
    public void setName(String name) {this.name = name;}

//    public void setGenres(ArrayList<Genre>){this.genres = genres;}

    public Genre findGenre(String name){
        for(int i=0; i<this.genres.size(); i++){
            if(this.genres.get(i).getName() == name){
                return genres.get(i);
            }
        }
        return null;
    }

    public void addGenre(Genre genre){
        this.genres.add(genre);
    }

    public void deleteGenre(Genre genre){
        this.genres.remove(genre);
    }
}