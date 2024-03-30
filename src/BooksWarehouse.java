import java.util.Arrays;

public class BooksWarehouse {

    private String name;
    private int nGenres;
    private Genre[] genres;

    BooksWarehouse(String name, int nGenres){
        this.name = name;
        this.nGenres = nGenres;
        this.genres = new Genre[nGenres];
    }

    public String getName() {return name;}
    public int getnGenres() {return nGenres;}
    public Genre[] getGenres() {return genres;}
    public void setName(String name) {this.name = name;}
    public void setGenres(Genre[] genres) {this.genres = genres;}

    public Genre findGenre(String name){
        for(int i=0; i<this.nGenres; i++){
            if(this.genres[i].getName()==name){
                return genres[i];
            }
        }
        return null;
    }

    public void addGenre(Genre genre){
        Genre[] copy = Arrays.copyOf(this.genres, this.nGenres + 1);
        copy[copy.length - 1] = genre;
        this.nGenres++;
        this.genres = copy;
    }

    public void deleteGenre(Genre genre){
        for (int i=0; i<this.nGenres; i++) {
            if (genres[i].getName() == genre.getName()) {
                Genre[] newArray = new Genre[this.nGenres - 1];
                System.arraycopy(this.genres, 0, newArray, 0, i);
                System.arraycopy(this.genres, i + 1, newArray, i, newArray.length - i);
                this.nGenres--;
                this.genres = newArray;
                break;
            }
        }
    }
}