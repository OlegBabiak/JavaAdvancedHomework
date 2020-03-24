package HomeWork02;

import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {
        AuthorDao authorDao = new AuthorDao();

        authorDao.insert("Гаррі", "Гаррісон");

        Author authorFromBD = authorDao.read(2);
        System.out.println(authorFromBD);


        authorFromBD.setFirstName(authorFromBD.getFirstName() + " Енсон");
        authorDao.update(authorFromBD);

        authorDao.delete(3);


        List<Author> all = authorDao.getAll();

        System.out.println(all);
        // book


        BookDao bookDao = new BookDao();

        bookDao.insert("220", "Світ");

        Book bookFromBD = bookDao.read(5);
        System.out.println(bookFromBD);


        bookFromBD.setBookTitle(bookFromBD.getBookTitle() + " смерті");
        bookDao.update(bookFromBD);

        bookDao.delete(4);


        List<Book> allBook = bookDao.getAll();

        System.out.println(allBook);

    }
}
