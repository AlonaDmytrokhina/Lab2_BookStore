import java.io.IOException;

public class UkrainianClassics implements Genres{
    @Override
    public void defaultBooks(BooksWarehouse booksWarehouse) throws IOException {
        String path = "UkrainianClassics.txt";
        Genre ukrainianClassics = new Genre("Українська класика", "...", path);

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

        String name3 = "Вибрані твори";
        String author3 = "Іван Франко";
        String info3 = "Поетичні твори – поема «Мойсей», філософська поезія «Легенда про вічне життя»," +
                "\n\tлірична поема-алегорія «Каменярі», вірші «Дрімають села», «Розвивайся ти, високий дубе…»," +
                "\n\t«Гімн (замість пролога)», «Ой ти, дівчино, з горіха зерня».";
        String producer3 = "Yakaboo";
        int amount3 = 5;
        double cost3 = 340;
        Book book3 = new Book(name3, author3, info3, producer3, amount3, cost3);

        String name4 = "Поза межами болю";
        String author4 = "Осип Турянський";
        String info4 = "В автобіографічній повісті «Поза межами болю» (1921), яка принесла письменникові світове визнання," +
                "\n\tавтор порушує важливу моральну тему, стверджуючи, що слід залишатися людиною навіть у " +
                "\n\tсамих безжальних умовах, та висловлює протест проти жахливого злочину — війни.";
        String producer4 = "Folio";
        int amount4 = 8;
        double cost4 = 310;
        Book book4 = new Book(name4, author4, info4, producer4, amount4, cost4);

        String name5 = "Камінний хрест";
        String author5 = "Василь Стефаник";
        String info5 = "Нелегко читати новели В. Стефаника, тому що він, за словами класика, пише «коротко, сильно і страшно»." +
                "\n\tАле їх треба-таки читати, співпереживаючи. Бо лише так, боліючи разом з автором та героями" +
                "\n\tйого творів, не даємо загрубіти й зачерствіти нашим душам і серцям.";
        String producer5 = "Folio";
        int amount5 = 3;
        double cost5 = 315;
        Book book5 = new Book(name5, author5, info5, producer5, amount5, cost5);

        String name6 = "Місто";
        String author6 = "Валер’ян Підмогильний";
        String info6 = "Роман \"Місто\", завершений у 1927 році, став першим урбаністичним твором в українській" +
                "\n\tлітературі з новими героями, проблематикою та манерою оповіді. В ньому" +
                "\n\tавтор описав молодь, яка на початку 1920-х років тисячами потягнулися з сіл, " +
                "\n\tщоб завоювати та зробити своїм українське місто. ";
        String producer6 = "РМ";
        int amount6 = 3;
        double cost6 = 420;
        Book book6 = new Book(name6, author6, info6, producer6, amount6, cost6);

        ukrainianClassics.addBook(book1);
        ukrainianClassics.addBook(book2);
        ukrainianClassics.addBook(book3);
        ukrainianClassics.addBook(book4);
        ukrainianClassics.addBook(book5);
        ukrainianClassics.addBook(book6);
        ukrainianClassics.toFile();
        booksWarehouse.addGenre(ukrainianClassics);
    }
}
