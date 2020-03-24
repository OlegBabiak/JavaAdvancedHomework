package HomeWork02;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    // Dao - data access object: об'єкт в якому описано як конектитись до таблички

    public static final String SELECT_FROM_BOOKS = "SELECT * FROM books";
    public static final String INSERT_INTO_BOOKS =
            "INSERT INTO books(price, book_title) values (?, ?)";
    public static final String READ_BY_ID = "select * from books where id =?";
    public static final String UPDATE_BOOKS =
            "UPDATE books set price = ?, book_title = ? where id = ?";
    public static final String DELETE_BY_ID = "delete from books where id =?";

    private Connection connection;

    public BookDao() {
        this.connection = ConnectionUtil.getConnection();;
    }

    public List<Book> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_FROM_BOOKS);

        List<Book> books = new ArrayList<>();

        while (resultSet.next()){
            books.add(Book.map(resultSet));

        }
        return books;

    }

    public int insert(String firstName, String lastName) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement(INSERT_INTO_BOOKS, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,firstName);
        preparedStatement.setString(2,lastName);

        preparedStatement.executeUpdate();

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        generatedKeys.next();
        return generatedKeys.getInt(1);

    }

    public Book read(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(READ_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet result = preparedStatement.executeQuery();
        result.next();
        return Book.map(result);
    }

    public void update(Book book) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOKS);
        preparedStatement.setInt(1, book.getPrice());
        preparedStatement.setString(2, book.getBookTitle());
        preparedStatement.setInt(3, book.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }



}
