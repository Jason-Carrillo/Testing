import java.sql.*;

public class Demo {
    public static void main(String[] args) throws SQLException {
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/codeup_test_db?serverTimezone=UTC&useSSL=false",
                    "root",
                    "codeup"
            );

            Statement statement = connection.createStatement();

//            DELETE
//            statement.execute()

//                    returns number of rows affected
//            statement.executeUpdate();


//            returns resultSet
            ResultSet rs = statement.executeQuery("SELECT * FROM albums");

            while (rs.next()){
                System.out.println("rs.getLong(\"id\") = " + rs.getLong("id"));
                System.out.println("rs.getString(\"name\") = " + rs.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}