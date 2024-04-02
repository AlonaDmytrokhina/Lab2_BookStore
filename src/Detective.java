public class Detective implements Genres{
    @Override
    public void defaultBooks(BooksWarehouse booksWarehouse){
        String path = "Detective.txt";
        Genre detective = new Genre("Детектив", "ounijo", path);

        String name1 = "Чорнильне серце";
        String author1 = "Роберт Галбрейт";
        String info1 = "Коли до офісу детективів приходить перелякана Еді Ледвелл, благаючи про розмову з Робін Еллакотт, " +
                "\n\tприватна розслідувачка не знає, що й думати. Еді, співавторку популярного коміксу «Чорнильно-чорне серце», " +
                "\n\tпереслідує таємнича особа з інтернету, що називає себе Аномія. Еді конче треба дізнатися, хто ця людина. " +
                "\n\tРобін вирішує, що у такій справі агенція допомогти не може — і більше не згадує про цей випадок, " +
                "\n\tаж поки за кілька днів не надходить шокуюча новина: Еді викрали, використавши шокер, та вбили на Гайґейтському цвинтарі.";
        String producer1 = "КСД";
        int amount1 = 4;
        double cost1 = 220;
        Book book1 = new Book(name1, author1, info1, producer1, amount1, cost1);

        String name2 = "Смерть на Нілі";
        String author2 = "Агата Крісті";
        String info2 = "Молодята Саймон і Ліннет Дойли вирушають у весільну подорож на пароплаві \"Карнак\". " +
                "\n\tЖаклін де Бельфор, давня подруга Ліннет, у якої та відбила коханого, вирішує своєю присутністю " +
                "\n\tзіпсувати їм медовий місяць. Одного ранку служниця знаходить місіс Дойл мертвою... " +
                "\n\tХтось вистрелив їй у голову, поки вона спала. На стіні біля вбитої лишається кривава буква \"Ж\". " +
                "\n\tОднак Жаклін має залізне алібі. У справу втручається відомий харизматичний детектив Еркюль Пуаро. " +
                "\n\tВиявляється, майже всі пасажири мали мотив для вбивства. Щось приховує чи не кожен із них, а кілька, " +
                "\n\tяк стає відомо, подорожують зі зброєю. То хто цей холоднокровний убивця, що не зупиняється на одному злочині? ";
        String producer2 = "Жорж";
        int amount2 = 2;
        double cost2 = 620;
        Book book2 = new Book(name2, author2, info2, producer2, amount2, cost2);

        String name3 = "Цвинтар для божевільних";
        String author3 = "Рей Бредбері";
        String info3 = "«Цвинтар для божевільних» — другий роман венеціанської трилогії Рея Бредбері, до " +
                "\n\tякої також входять «Смерть — діло самотнє» і «Нехай усі позбудуться Констанс» " +
                "\n\tКнига нагадує лабіринт смертей, справжніх та уявних, де вимисел такий же реальний, як і дійсність." +
                "\n\tДія твору відбувається в оповитому магією Голівуді, де не існує часових чи просторових " +
                "\n\tрамок, де динозаври розгулюють поряд із собором Нотр-Дам. ";
        String producer3 = "КСД";
        int amount3 = 4;
        double cost3 = 190;
        Book book3 = new Book(name3, author3, info3, producer3, amount3, cost3);

        String name4 = "Сімейна гра";
        String author4 = "Кетрін Стедмен";
        String info4 = "Життя молодої письменниці Гаррієт Рід круто змінюється: зустрівши чоловіка своєї мрії, " +
                "\n\tвона готується до ідеального весілля у Нью-Йорку. Його родина — одна з наймогутніших в Америці," +
                "\n\tі їхній шарм та, ніде правди діти, статки нікого не лишають байдужим.";
        String producer4 = "РМ";
        int amount4 = 1;
        double cost4 = 420;
        Book book4 = new Book(name4, author4, info4, producer4, amount4, cost4);

        String name5 = "Ловець невинних душ";
        String author5 = "Донато Каррізі";
        String info5 = "Події детективного роману «Ловець невинних душ» розгортаються в Римі, що постає" +
                "\n\tз уяви автора зовсім не таким, до якого всі звикли. Місто архітектурних шедеврів і мистецьких" +
                "\n\tнасолод окутане цілим павутинням злочинів на тлі містицизму. Люди безслідно зникають," +
                "\n\tяк-от звичайна студентка із зачиненої зсередини квартири. Поліція вже незабаром розвела руками," +
                "\n\tі за пошуки дівчини взявся Маркус — спеціаліст із аномалій, що має здатність бачити послання зла" +
                "\n\tв найзаплутаніших злочинах. На своєму шляху він зустрічає Сандру — інспекторку-криміналістку. " ;
        String producer5 = "Vivat";
        int amount5 = 6;
        double cost5 = 290;
        Book book5 = new Book(name5, author5, info5, producer5, amount5, cost5);


        String name6 = "Ловець тіні";
        String author6 = "Донато Каррізі";
        String info6 = " Маркус — спеціаліст з аномалій, що має здатність бачити послання зла в найзаплутаніших злочинах." +
                "\n\tСандра — інспекторка-криміналістка, чия робота полягає в фотографуванні місць, " +
                "\n\tде сталося вбивство. І коли в Римі стаються жахливі вбивства і місту загрожує жахлива небезпека, " +
                "\n\tвони об’єднують зусилля, щоб упіймати чудовисько. Але як це зробити без речових доказів та будь-яких підказок?";
        String producer6 = "Vivat";
        int amount6 = 2;
        double cost6 = 280;
        Book book6 = new Book(name6, author6, info6, producer6, amount6, cost6);


        detective.addBook(book1);
        detective.addBook(book2);
        detective.addBook(book3);
        detective.addBook(book4);
        detective.addBook(book5);
        detective.addBook(book6);

        detective.toFile();
        booksWarehouse.addGenre(detective);
    }
}
