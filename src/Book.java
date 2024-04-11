public class Book {
    private String name;
    private String author;
    private String info;
    private String producer;
    private int amount;
    private double cost;

    Book(String name, String author, String info, String producer, int amount, double cost){
        this.name = name;
        this.author = author;
        this.info = info;
        this.producer = producer;
        this.amount = amount;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public String getProducer() {
        return producer;
    }

    public int getAmount() {
        return amount;
    }

    public double getCost() {
        return cost;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {this.name = name;}

    public void setInfo(String info) {this.info = info;}

    public void setProducer(String producer) {this.producer = producer;}

    public void setAmount(int amount) {this.amount = amount;}

    public void setCost(double cost) {this.cost = cost;}


    public double getOverallCost(){return this.amount*this.cost;}

    public String toString(){
        String res = "";
        res+="\nНазва: "+this.name;
        res+="\nАвтор: "+this.author;
        res+="\nОпис: "+this.info;
        res+="\nВидавництво: "+this.producer;
        res+="\nКількість на складі: "+this.amount;
        res+="\nЦіна за одиницю товару: "+this.cost;
        return res;
    }

}