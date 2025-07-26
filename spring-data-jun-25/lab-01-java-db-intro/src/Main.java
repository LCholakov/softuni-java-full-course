import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        // connect to SQL server
        String jdbc = "jdbc:mysql://localhost:3306/soft_uni";
        String username = "root";
        String password = "azisevelik";

        Properties properties = new Properties();
        properties.setProperty("user", username);
        properties.setProperty("password", password);

        Connection connection =
                DriverManager.getConnection(jdbc, properties);

        System.out.println();

        // Execute query
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT * FROM employees LIMIT 10");
        ResultSet resultSet = preparedStatement.executeQuery();

        // Parse result
        while (resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            String jobTitle = resultSet.getString("job_title");
            double salary = resultSet.getDouble("salary");
            System.out.printf("%s %s - %.2f%n", firstName, jobTitle, salary);
        }


    }
}