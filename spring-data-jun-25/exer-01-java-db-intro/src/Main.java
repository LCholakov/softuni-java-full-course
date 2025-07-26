import java.sql.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        // connect to SQL server
        String jdbc = "jdbc:mysql://localhost:3306/minions_db";
        String username = "root";
        String password = "azisevelik";

        Properties properties = new Properties();
        properties.setProperty("user", username);
        properties.setProperty("password", password);

        Connection connection =
                DriverManager.getConnection(jdbc, properties);

        System.out.println("Connected to the database successfully!");

        // Execute query

//        Exer 2
//        PreparedStatement preparedStatement = connection
//                .prepareStatement("""
//                                select name, COUNT(minion_id) count from villains
//                                join minions_villains on villains.id = minions_villains.villain_id
//                                group by name
//                                having count > 15
//                                order by count desc;
//                                """);
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        // Parse result
//        while (resultSet.next()) {
//            String name = resultSet.getString("name");
//            int count = resultSet.getInt("count");
//            System.out.printf("%s - %d%n", name, count);
//        }

//        exer 3
//        Scanner scan = new Scanner(System.in);
//        int villainId = Integer.parseInt(scan.nextLine());
//
//        boolean villainExists = printVillain(connection, villainId);
//        if(villainExists)
//            printMinions(connection, villainId);

//        exer 4
        Scanner scan = new Scanner(System.in);
        String [] minionData = scan.nextLine().split("\\s+");
        String minionName = minionData[1];
        int minionAge = Integer.parseInt(minionData[2]);
        String minionTown = minionData[3];
        String villainName = scan.nextLine().split("\\s+")[1];

        int townId = ensureTown(connection, minionTown);
        int villainId = ensureVillain(connection, villainName);
        int minionId = createMinion(connection, minionName, minionAge, ensureTown(connection, minionTown));
        connectMinionAndVillain(connection, minionId, villainId);
        System.out.println("Successfully added minion " + minionName + " to villain " + villainName + ".");

//        exer 7

        // best solution
        PreparedStatement statement = connection.prepareStatement("select name from minions");
        ResultSet resultSet = statement.executeQuery();

        List<String> names = new ArrayList<>();
        while (resultSet.next()) {
            names.add(resultSet.getString("name"));
        }

//        for (int i = 0; i < names.size() / 2; i++) {
//            System.out.println(names.get(i));
//            System.out.println(names.get(names.size() - 1 - i));
//        }

        // interesting solution

        PreparedStatement statementInteresting = connection.prepareStatement("select name from minions",
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSetInteresting = statementInteresting.executeQuery();
        int count = 0;
        while (resultSetInteresting.next()) count++;
        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                resultSetInteresting.absolute(i / 2 + 1);
            } else {
                resultSetInteresting.absolute(count - (i - 1) / 2);
            }

            System.out.println(resultSetInteresting.getString("name"));
        }


//        TODO 2:48:40 exer 8 and a couple more
//        link to video: https://softuni.bg/trainings/resources/video/117915/video-19-june-2025-tonislav-troev-spring-data-june-2025/4952


        // close connection
        connection.close();

    }

    private static void connectMinionAndVillain(Connection connection, int minionId, int villainId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into minions_villains (minion_id, villain_id) value (?, ?);"
                , Statement.RETURN_GENERATED_KEYS
        );
        preparedStatement.setInt(1, minionId);
        preparedStatement.setInt(2, villainId);
        preparedStatement.executeUpdate();
    }

    private static int ensureTown(Connection connection, String town) throws SQLException{
        PreparedStatement preparedStatement = connection
                .prepareStatement("""
                        Select * from towns
                        where name = ?;
                                """);
        preparedStatement.setString(1, town);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt(1);
        }

        PreparedStatement insertStatement = connection.prepareStatement(
                "insert into towns (name) value (?);"
                , Statement.RETURN_GENERATED_KEYS
        );
        insertStatement.setString(1, town);
        insertStatement.executeUpdate();

        ResultSet generatedKeys = insertStatement.getGeneratedKeys();
        if (!generatedKeys.next())
            throw new IllegalStateException("Could not access generated key for town.");
        System.out.printf("Town %s added to the database.%n", town);
        return generatedKeys.getInt(1);
    }

    private static int ensureVillain(Connection connection, String villainName) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("""
                        Select * from villains
                        where name = ?;
                                """);
        preparedStatement.setString(1, villainName);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt(1);
        }

        PreparedStatement insertStatement = connection.prepareStatement(
                "insert into villains (name, evilness_factor) value (?, 'evil');"
                , Statement.RETURN_GENERATED_KEYS
        );
        insertStatement.setString(1, villainName);
        insertStatement.executeUpdate();

        ResultSet generatedKeys = insertStatement.getGeneratedKeys();
        if (!generatedKeys.next())
            throw new IllegalStateException("Could not access generated key for villain.");
        System.out.printf("Villain %s was added to the database.%n", villainName);
        return generatedKeys.getInt(1);
    }

    private static int createMinion(Connection connection, String minionName, int minionAge, int townId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into minions (name, age, town_id) value (?, ?, ?);",
                Statement.RETURN_GENERATED_KEYS
        );
        preparedStatement.setString(1, minionName);
        preparedStatement.setInt(2, minionAge);
        preparedStatement.setInt(3, townId);
        preparedStatement.executeUpdate();

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (!generatedKeys.next())
            throw new IllegalStateException("Could not access generated key for minion.");
        return generatedKeys.getInt(1);
    }

    private static void printMinions(Connection connection, int villainId) throws SQLException{
        PreparedStatement preparedStatement = connection
                .prepareStatement("""
                        select m.name, m.age
                        from villains v
                        join minions_db.minions_villains mv on v.id = mv.villain_id
                        join minions m on mv.minion_id = m.id
                        where v.id = ?;
                                """);
        preparedStatement.setInt(1, villainId);
        ResultSet resultSet = preparedStatement.executeQuery();

        int idx = 0;
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String age = resultSet.getString("age");

            System.out.printf("%d. %s %s%n", ++idx, name, age);
        }
    }

    private static boolean printVillain(Connection connection, int villainId) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("""
                                select name from villains where id = ?;
                                """);
        preparedStatement.setInt(1, villainId);
        ResultSet resultSet = preparedStatement.executeQuery();

        // Parse result
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            System.out.printf("Villain: %s%n", name);

            return true;
        }

        System.out.println("Villain with this ID does not exist.");
        return false;
    }
}