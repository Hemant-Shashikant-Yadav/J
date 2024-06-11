import java.sql.*;

public class ee {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            // Create a database
            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS mydatabase";
            statement.executeUpdate(createDatabaseQuery);

            // Switch to the created database
            String useDatabaseQuery = "USE mydatabase";
            statement.executeUpdate(useDatabaseQuery);

            // Create a table
            String createTableQuery = "CREATE TABLE IF NOT EXISTS mytable (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50))";
            statement.executeUpdate(createTableQuery);

            // Insert a row into the table
            String insertRowQuery = "INSERT INTO mytable (name) VALUES ('John')";
            statement.executeUpdate(insertRowQuery);

            System.out.println("Database and table created, row inserted successfully.");

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
