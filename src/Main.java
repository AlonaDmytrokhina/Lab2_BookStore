import java.util.Scanner;

public class Main {
    static BooksWarehouse booksWarehouse;
    public static void main(String[] args) {
        booksWarehouse = new BooksWarehouse("Book worm");
        defaultGenres();
        deleteBook();
    }

    private static void defaultGenres(){
        String path1 = "Detective.txt";
        Genre detective = new Genre("Детектив", "ounijo", path1);

        String nameDet1 = "Чорнильне серце";
        String authorDet1 = "Роберт Галбрейт";
        String infoDet1 = "Коли до офісу детективів приходить перелякана Еді Ледвелл, благаючи про розмову з Робін Еллакотт, " +
                "\n\tприватна розслідувачка не знає, що й думати. Еді, співавторку популярного коміксу «Чорнильно-чорне серце», " +
                "\n\tпереслідує таємнича особа з інтернету, що називає себе Аномія. Еді конче треба дізнатися, хто ця людина. " +
                "\n\tРобін вирішує, що у такій справі агенція допомогти не може — і більше не згадує про цей випадок, " +
                "\n\tаж поки за кілька днів не надходить шокуюча новина: Еді викрали, використавши шокер, та вбили на Гайґейтському цвинтарі.";
        String producerDet1 = "КСД";
        int amountDet1 = 4;
        double costDet1 = 220;
        Book book1 = new Book(nameDet1, authorDet1, infoDet1, producerDet1, amountDet1, costDet1);

        String nameDet2 = "Смерть на Нілі";
        String authorDet2 = "Агата Крісті";
        String infoDet2 = "Молодята Саймон і Ліннет Дойли вирушають у весільну подорож на пароплаві \"Карнак\". " +
                "\n\tЖаклін де Бельфор, давня подруга Ліннет, у якої та відбила коханого, вирішує своєю присутністю " +
                "\n\tзіпсувати їм медовий місяць. Одного ранку служниця знаходить місіс Дойл мертвою... " +
                "\n\tХтось вистрелив їй у голову, поки вона спала. На стіні біля вбитої лишається кривава буква \"Ж\". " +
                "\n\tОднак Жаклін має залізне алібі. У справу втручається відомий харизматичний детектив Еркюль Пуаро. " +
                "\n\tВиявляється, майже всі пасажири мали мотив для вбивства. Щось приховує чи не кожен із них, а кілька, " +
                "\n\tяк стає відомо, подорожують зі зброєю. То хто цей холоднокровний убивця, що не зупиняється на одному злочині? ";
        String producerDet2 = "Жорж";
        int amountDet2 = 2;
        double costDet2 = 620;
        Book book2 = new Book(nameDet2, authorDet2, infoDet2, producerDet2, amountDet2, costDet2);

        detective.addBook(book1);
        detective.addBook(book2);
        detective.toFile();

        booksWarehouse.addGenre(detective);
    }

    private static void addBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Жанр: ");
        String genre = scanner.nextLine();
        while(booksWarehouse.findGenre(genre)==null){
            System.out.println("Такого жанру не існує.");
            System.out.print("Жанр: ");
            genre = scanner.nextLine();
        }
        System.out.print("Назва: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Автор: ");
        String author = scanner.nextLine();
        System.out.print("Опис: ");
        String info = scanner.nextLine();
        System.out.print("Видавництво: ");
        String producer = scanner.nextLine();
        System.out.print("Кількість на складі: ");
        int amount = scanner.nextInt();
        System.out.print("Ціна за одиницю товару: ");
        double cost = scanner.nextDouble();
        scanner.nextLine();

        Book book = new Book(name, author, info, producer, amount, cost);
        booksWarehouse.findGenre(genre).addBook(book);
        booksWarehouse.findGenre(genre).toFile();
        scanner.close();
    }

    private static void deleteBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Жанр: ");
        String genre = scanner.nextLine();
        while(booksWarehouse.findGenre(genre)==null){
            System.out.println("Такого жанру не існує.");
            System.out.print("Жанр: ");
            genre = scanner.nextLine();
        }
        System.out.print("Назва: ");
        String name = scanner.nextLine();
        while(booksWarehouse.findBook(name) == null){
            System.out.println("Такої книги не існує.");
            System.out.print("Назва: ");
            name = scanner.nextLine();
        }
        booksWarehouse.deleteBook(name);
        booksWarehouse.findGenre(genre).toFile();
        scanner.close();
    }
}