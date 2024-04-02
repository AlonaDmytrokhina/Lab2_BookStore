public class UkrainianClassics implements Genres{
    @Override
    public void defaultBooks(BooksWarehouse booksWarehouse){
        String path = "UkrainianClassics.txt";
        Genre ukrainianClassics = new Genre("Українська класика", "ounijo", path);

        String name1 = "Майстер корабля.Байгород";
        String author1 = "Юрій Яновський";
        String info1 = "Одеса, у яку прилітали тільки скажені шторми з моря. Українське кіно, свіже і сміливе," +
                "\n\tяк юнга на високій щоглі. Молоді люди, які шукають себе і знаходять — дружбу, кохання," +
                "\n\tвірність, мужність. Режисер, художник, балерина, матрос, одеські рибалки," +
                "\n\tпортові дівчата, директор кінофабрики, власник шхуни.";
        String producer1 = "Віхола";
        int amount1 = 6;
        double cost1 = 320;
        Book book1 = new Book(name1, author1, info1, producer1, amount1, cost1);

        String name2 = "Маруся Богуславка";
        String author2 = "Іван Багряний";
        String info2 = "Роман «Маруся Богуславка» започаткував епопею «Буйний вітер», задуману" +
                "\n\tІ. Багряним як трилогія про українську молодь у передвоєнні й воєнні роки, яка," +
                "\n\tоднак, так і залишилася незавершеною.";
        String producer2 = "Folio";
        int amount2 = 2;
        double cost2 = 343;
        Book book2 = new Book(name2, author2, info2, producer2, amount2, cost2);

        ukrainianClassics.addBook(book1);
        ukrainianClassics.addBook(book2);
        ukrainianClassics.toFile();
        booksWarehouse.addGenre(ukrainianClassics);
    }
}
