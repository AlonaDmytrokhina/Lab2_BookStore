import java.io.IOException;

public class EnglishModern implements Genres{
    @Override
    public void defaultBooks(BooksWarehouse booksWarehouse) throws IOException {
        String path = "EnglishModern.txt";
        Genre englishModern = new Genre("Література англійською", "ounijo", path);

        String name1 = "Us against you";
        String author1 = "Fredrikv Backman";
        String info1 = "Tucked in a forest in the frozen north, Beartown is full of tough and hardworking residents. " +
                "\n\tThey don't expect life to be easy, but they do expect it to be fair. " +
                "\n\tWhich is why the sudden loss of their hockey players to the rival town of Hed hurts. " +
                "\n\tEveryone needs something to cheer for in the long winter nights.";
        String producer1 = "Penguin";
        int amount1 = 1;
        double cost1 = 625;
        Book book1 = new Book(name1, author1, info1, producer1, amount1, cost1);

        String name2 = "Me before you";
        String author2 = "Jojo Moyes";
        String info2 = "When Lou Clark loses her job at a café, she is given a job caring for Will Traynor. " +
                "\n\tWill was disabled in a motorbike accident. Lou knows she needs the money. " +
                "\n\tWill knows that his accident took away his love of life. Neither of them know that they're going to change each other's lives forever." +
                "\n\tgoing to change each other's lives forever." ;
        String producer2 = "Penguin";
        int amount2 = 2;
        double cost2 = 454;
        Book book2 = new Book(name2, author2, info2, producer2, amount2, cost2);

        String name3 = "The secret history";
        String author3 = "Donna Tartt ";
        String info3 = "«Under the influence of their charismatic classics professor, a group of clever, eccentric misfits at an elite New England " +
                "\n\tcollege discover a way of thinking and living that is a world away from the humdrum existence of their contemporaries. ";
        String producer3 = "Penguin";
        int amount3 = 1;
        double cost3 = 570;
        Book book3 = new Book(name3, author3, info3, producer3, amount3, cost3);

        String name4 = "The Tuesday Club Murders";
        String author4 = "Agatha Christie";
        String info4 = "In a peaceful retirement village, four unlikely friends meet up once a week to investigate unsolved murders." +
                "\n\tBut when a brutal killing takes place on their very doorstep, " +
                "\n\tthe Thursday Murder Club find themselves in the middle of their first live case.";
        String producer4 = "Penguin";
        int amount4 = 3;
        double cost4 = 487;
        Book book4 = new Book(name4, author4, info4, producer4, amount4, cost4);

        String name5 = "Pride and Prejudice";
        String author5 = "Jane Austen";
        String info5 = "Designed to appeal to the booklover, the Macmillan Collector's Library is a series of beautiful gift editions" +
                "\n\tof much loved classic titles. Macmillan Collector's Library are books to love and treasure." ;
        String producer5 = "Pan Macmillan";
        int amount5 = 1;
        double cost5 = 549;
        Book book5 = new Book(name5, author5, info5, producer5, amount5, cost5);


        String name6 = "The little prince";
        String author6 = "Antoine De Saint-Exupery";
        String info6 = " When I fly among the stars and see the lights in the distance, I say to myself that this is my little Consuelo is calling me…” " +
                "\n\tAntoine de Saint-Exupery wrote about love for his wife. A graceful Consuelo Suncin inspired an outstanding " +
                "\n\t French writer, poet and pilot to create a beautiful rose in his famous all over the world book The Little Prince. ";
        String producer6 = "Pan Macmillan";
        int amount6 = 2;
        double cost6 = 625;
        Book book6 = new Book(name6, author6, info6, producer6, amount6, cost6);


        englishModern.addBook(book1);
        englishModern.addBook(book2);
        englishModern.addBook(book3);
        englishModern.addBook(book4);
        englishModern.addBook(book5);
        englishModern.addBook(book6);

        englishModern.toFile();
        booksWarehouse.addGenre(englishModern);
    }
}
