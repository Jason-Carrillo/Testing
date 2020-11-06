import java.sql.*;

import com.mysql.cj.jdbc.Driver;

public class Demo {
    public static void main(String[] args) throws SQLException {
        long idToUpdate = 0;

        Album album = new Album();

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
            ResultSet rs = statement.executeQuery("SELECT * FROM albums ORDER BY sales");

            while (rs.next()){
                album.setId(rs.getLong("id"));
                album.setName(rs.getString(3));
                album.setSales(rs.getDouble("sales"));

                System.out.println("rs.getLong(\"id\") = " + rs.getLong("id"));
                System.out.println("rs.getString(\"name\") = " + rs.getString(3));
                System.out.println("rs.getDouble(\"sales\") = " + rs.getDouble("sales"));
            }

            System.out.println("album.getId() = " + album.getId());
            System.out.println("album.getName() = " + album.getName());
            System.out.println("album.getSales() = " + album.getSales());


            // HOW TO INSERT
            // INSERT example
//            String sql = "INSERT into albums (artist, name, release_date, sales, genre VALUES('Nelly Furtado'," +
//                    "'Folklore', 2003, 50, pop)";
//
//            long latestId = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
//
//            rs = statement.getGeneratedKeys();


            // HOW TO DELETE
            // DELETE example

//            long idToDelete = 34;
//            sql = "DELETE FROM albums where ID = " + idToDelete;
//            statement.execute(sql);
//            System.out.println(idToDelete + " is gone!");

            // HOW TO UPDATE
            // UPDATE Example

//            double sales = 60.5;
//            statement.execute("UPDATE albums SET sales = " + sales + " WHERE id = " + idToUpdate);

            if (rs.next()) {
                System.out.println("Inserted a new record! New id: " + rs.getLong(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}