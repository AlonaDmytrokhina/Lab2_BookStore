public class Book {
    private String name;
    private String info;
    private String producer;
    private int amount;
    private double cost;

    Book(String name, String info, String producer, int amount, double cost){
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getOverallCost(){return this.amount*this.cost;}
}