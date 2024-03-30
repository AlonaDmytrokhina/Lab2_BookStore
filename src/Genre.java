public class Genre {
    private String name;
    private String info;

    Genre(String name, String info){
        this.name = name;
        this.info = info;
    }

    public String getName() {return name;}

    public String getInfo() {return info;}

    public void setName(String name) {this.name = name;}

    public void setInfo(String info) {this.info = info;}
}
