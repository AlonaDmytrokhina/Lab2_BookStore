import java.io.IOException;

public class UkrainianModern implements Genres{
    @Override
    public void defaultBooks(BooksWarehouse booksWarehouse) throws IOException {
        String path = "UkrainianModern.txt";
        Genre ukrainianModern = new Genre("Українська сучасна", "ounijo", path);

        String name1 = "Ліниві і ніжні";
        String author1 = "Юрій Іздрик";
        String info1 = "До книги культового українського автора Юрія Іздрика увійшли найкращі вірші" +
                "\n\tз усіх його попередніх збірок, а також найновіші поезії. ";
        String producer1 = "А-ба-ба-га-ла-ма-га";
        int amount1 = 4 ;
        double cost1 = 360 ;
        Book book1 = new Book(name1, author1, info1, producer1, amount1, cost1);

        String name2 = "Інтернат";
        String author2 = "Сергій Жадан";
        String info2 = "ійна завжди приходить несподівано. Просто посеред розумієш, що чуєш звук пострілів та бачиш вогонь у вікні," +
                "\n\tі звичний хід днів безповоротно порушується. Тепер настав час боротися за власне виживання та вирішити, " +
                "\n\tза якими барикадами доведеться опинитися.";
        String producer2 = "Meridian Czernowitz";
        int amount2 = 1;
        double cost2 = 415;
        Book book2 = new Book(name2, author2, info2, producer2, amount2, cost2);

        String name3 = "Бомжі Донбасу";
        String author3 = "Олексій Чупа";
        String info3 = "« Роман поєднує реалізм та утопію. До товариства україномовних макіївських безхатченків потрапляє книга  " +
                "\n\tз альтернативною історією про державу, яка існувала тисячу років тому. Автор намагається вписати " +
                "\n\tДонбас в контекст української історії з часів Хрещення Русі.";
        String producer3 = "Discursus";
        int amount3 = 5;
        double cost3 = 280;
        Book book3 = new Book(name3, author3, info3, producer3, amount3, cost3);

        String name4 = "Аптекар";
        String author4 = "Юрій Винничук";
        String info4 = "Події відомого роману провідного українського письменника Юрія Винничука «Аптекар» відбуваються у 1646–1648 роках " +
                "\n\tспочатку у венеційській республіці, а далі — у Львові. Історичне тло уміло використане для захопливої гри в дійсне-недійсне," +
                "\n\tде персонажі історичні сусідять з вигаданими, а їхні складні стосунки формуються у любовні трикутники.";
        String producer4 = " А-ба-ба-га-ла-ма-га";
        int amount4 = 3;
        double cost4 = 480;
        Book book4 = new Book(name4, author4, info4, producer4, amount4, cost4);

        String name5 = "Битва за життя";
        String author5 = "Анатолій Дністровий";
        String info5 = "Перед вами — щоденник-хроніка наближення, початку і розгортання великої війни. Битва за життя й свободу триває," +
                "\n\tУкраїна дає рішучу відсіч «русскому міру». Автор є спостерігачем та учасником низки описаних подій, зокрема як митець, аналітик, військовослужбовець." +
                "\n\tзокрема як митець, аналітик, військовослужбовець." ;
        String producer5 = "Vivat";
        int amount5 = 2;
        double cost5 = 430;
        Book book5 = new Book(name5, author5, info5, producer5, amount5, cost5);


        String name6 = " Mісто з химерами";
        String author6 = " Олесь Ільченко";
        String info6 = "Роман Олеся Ільченка «Місто з химерами» дозволяє повернутись в часі і зануритись у життя Києва початку ХХ століття:" +
                "\n\tзазирнути за лаштунки театру Соловцова, зустріти Ларису Косач в Музеї старожитностей, " +
                "\n\tвипити гарячого шоколаду в кафе «Семадені», поспостерігати за будівництвом Миколаївського костелу " +
                "\n\tі навіть політати аеропланом разом із Ігорем Сікорським.";
        String producer6 = "Комора";
        int amount6 = 3;
        double cost6 = 275 ;
        Book book6 = new Book(name6, author6, info6, producer6, amount6, cost6);


        ukrainianModern.addBook(book1);
        ukrainianModern.addBook(book2);
        ukrainianModern.addBook(book3);
        ukrainianModern.addBook(book4);
        ukrainianModern.addBook(book5);
        ukrainianModern.addBook(book6);

        ukrainianModern.toFile();
        booksWarehouse.addGenre(ukrainianModern);
    }
}
