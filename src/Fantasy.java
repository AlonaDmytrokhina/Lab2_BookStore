import java.io.IOException;

public class Fantasy implements Genres{
    @Override
    public void defaultBooks(BooksWarehouse booksWarehouse) throws IOException {
        String path = "Fantasy.txt";
        Genre fantasy = new Genre("Фентезі", "...", path);

        String name1 = "Правда";
        String author1 = "Террі Пратчетт";
        String info1 = "«Правда» - один із найяскравіших позациклових творів у серії «Дискосвіт» майстра гумористичних " +
                "фентезійних романів Террі Пратчетта. Тонка межа між фактами й чутками, жарти й алюзії надійно вплітають " +
                "«Правду» у сучасні реалії і творять майстерну сатиру на інформаційну сферу та суспільство загалом.";
        String producer1 = "Видавництво старого лева";
        int amount1 = 4;
        double cost1 = 410 ;
        Book book1 = new Book(name1, author1, info1, producer1, amount1, cost1);

        String name2 = "Гобіт або Туди і Звідти";
        String author2 = "Дж.Р.Р Толкін ";
        String info2 = "Це історія надзвичайної пригоди, яку втнула ватага ґномів, узявшись відшукати загарбане драконом золото. " +
                "Мимохіть учасником цієї ризикованої виправи став Більбо Торбин, прихильний до комфорту і позбавлений амбіцій " +
                "гобіт, котрий, на власний подив, виявив неабияку винахідливість і вправність у ролі зломщика.";
        String producer2 = "Астролябія";
        int amount2 = 2;
        double cost2 = 680;
        Book book2 = new Book(name2, author2, info2, producer2, amount2, cost2);

        String name3 = "Гра престолів";
        String author3 = "Джордж Р.Р Мартін";
        String info3 = "«Перша книга циклу - \"Гра престолів\" - це захопливий світ Сімох Королівств, де літо й зима тривають по кілька років, " +
                "з півночі наступають загадкові й моторошні вороги, а вельможні родини ведуть ненастанну війну за престол. ";
        String producer3 = "КСД";
        int amount3 = 1;
        double cost3 = 810;
        Book book3 = new Book(name3, author3, info3, producer3, amount3, cost3);

        String name4 = "Макова війна";
        String author4 = "Ребекка Кван";
        String info4 = "Cирота війни з глухої провінції зробила неможливе — на відмінно склала загальноімперський іспит Кедзю " +
                "для вступу в військову академію. Це стало несподіванкою для всіх: екзаменаторів, які не могли повірити " +
                "в те, що бідна селючка здатна на таке.";
        String producer4 = "Жорд";
        int amount4 = 3;
        double cost4 = 520;
        Book book4 = new Book(name4, author4, info4, producer4, amount4, cost4);

        String name5 = "Голодні ігри балада про співочих пташок і змій";
        String author5 = "Сюзанна Коллінз";
        String info5 = "Роман «Балада про співочих пташок і змій» є приквелом трилогії-бестселера «Голодні ігри». " +
                "Історія, змальована в романі, відбувається за 64 роки до основних подій трилогії." +
                "нПід час повстання округів впливова родина 18-річного Коріолана Сноу втратила майже все. " +
                "Єдиний шанс Коріолана повернути сім’ї минулу велич і заможність — стипендія на навчання в Університеті.";
        String producer5 = "Bookchef";
        int amount5 = 3 ;
        double cost5 = 280;
        Book book5 = new Book(name5, author5, info5, producer5, amount5, cost5);


        String name6 = "Ці порожні обітниці";
        String author6 = "Лексі Раян";
        String info6 = " Брі ненавидить фейрі й переконана, що ніколи не працюватиме на них, навіть якщо доведеться голодувати й жебракувати." +
                "Та коли її сестра потрапляє до рук жорстокого короля Немилостивого Двору фейрі, Брі розуміє, що піде на все, аби тільки повернути її." ;
        String producer6 = "РМ";
        int amount6 = 1;
        double cost6 = 660;
        Book book6 = new Book(name6, author6, info6, producer6, amount6, cost6);

        fantasy.addBook(book1);
        fantasy.addBook(book2);
        fantasy.addBook(book3);
        fantasy.addBook(book4);
        fantasy.addBook(book5);
        fantasy.addBook(book6);

        fantasy.toFile();
        booksWarehouse.addGenre(fantasy);
    }
}
