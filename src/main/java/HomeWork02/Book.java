package HomeWork02;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Book {

    private int id;
    private int price;
    private String bookTitle;

    public Book(int id, int price, String bookTitle) {
        this.id = id;
        this.price = price;
        this.bookTitle = bookTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public static Book map(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        int price = result.getInt("price");
        String bookTitle = result.getString("book_title");

        return new Book(id, price, bookTitle);
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", price='" + price + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                '}';
    }
}
