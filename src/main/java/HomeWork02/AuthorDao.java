package HomeWork02;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {
    // Dao - data access object: об'єкт в якому описано як конектитись до таблички

    public static final String SELECT_FROM_AUTHORS = "SELECT * FROM authors";
    public static final String INSERT_INTO_AUTHORS =
            "INSERT INTO authors(authors_name, authors_last_name) values (?, ?)";
    public static final String READ_BY_ID = "select * from authors where id =?";
    public static final String UPDATE_AUTHORS =
            "UPDATE authors set authors_name = ?, authors_last_name = ? where id = ?";
    public static final String DELETE_BY_ID = "delete from authors where id =?";

    private Connection connection;

    public AuthorDao() {
        this.connection = ConnectionUtil.getConnection();;
    }

    public List<Author> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_FROM_AUTHORS);

        List<Author> authors = new ArrayList<>();

        while (resultSet.next()){
            authors.add(Author.map(resultSet));

        }
        return authors;

    }

    public int insert(String firstName, String lastName) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement(INSERT_INTO_AUTHORS, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,firstName);
        preparedStatement.setString(2,lastName);

        preparedStatement.executeUpdate();

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        generatedKeys.next();
        return generatedKeys.getInt(1);

    }

    public Author read(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(READ_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet result = preparedStatement.executeQuery();
        result.next();
        return Author.map(result);
    }

    public void update(Author author) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_AUTHORS);
        preparedStatement.setString(1, author.getFirstName());
        preparedStatement.setString(2, author.getLastName());
        preparedStatement.setInt(3, author.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }



}
