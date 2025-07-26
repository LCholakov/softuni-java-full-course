import java.sql.*;
import java.util.Scanner;

public class RemoveVIllain_06 {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);

        int villainId = Integer.parseInt(scan.nextLine());

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", "root", "azisevelik");

        String villainName = findVillain(connection, villainId);

        if(villainName == null) {
            System.out.println("No such villain was found");
        }
        else {
            connection.setAutoCommit(false);
            try {
                int releasedMinionCount = deleteMinionConnection(connection, villainId);
                deleteVillain(connection, villainId);
                connection.commit();

                System.out.println(villainName + " was deleted");
                System.out.printf("%d minions released%n", releasedMinionCount);
            } catch (SQLException e) {
                connection.rollback();
                throw e;
            }
        }
    }

    private static int deleteMinionConnection(Connection connection, int villainId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM minions_villains WHERE villain_id = ?");
        statement.setInt(1, villainId);
        return statement.executeUpdate();
    }

    private static void deleteVillain(Connection connection, int villainId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM villains WHERE id = ?");
        statement.setInt(1, villainId);
        statement.executeUpdate();
    }

    private static String findVillain(Connection connection, int villainId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT name FROM villains WHERE id = ?");
        statement.setInt(1, villainId);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next()) {
            return null;
        }
        return resultSet.getString("name");
    }
}
