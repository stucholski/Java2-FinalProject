package finalproj;
import java.sql.*;

import org.apache.derby.jdbc.EmbeddedDataSource;

public class SetupDerbyDatabase {

    public static void main(String[] args) throws Exception {

        //String url = "jdbc:derby:;databasename=kitchen_database;create=true";

        try {

            EmbeddedDataSource ds = new EmbeddedDataSource();
            ds.setDatabaseName("kitchen_database");
            ds.setCreateDatabase("create");

            Connection conn = ds.getConnection();

            Statement stmt = conn.createStatement();

            System.out.println(conn);

            try {
                stmt.executeUpdate("DROP TABLE ingredients");
            }catch(Exception e) {
                System.out.println("Could not drop table ingredients, ingredients table does not exist.");
            }
            try {
                stmt.executeUpdate("DROP TABLE utencils");
            }catch(Exception e) {
                System.out.println("Could not drop table utencils, utencils table does not exist.");
            }

            try {
                stmt.executeUpdate("DROP TABLE players");
            }catch(Exception e) {
                System.out.println("Could not drop table players, players table does not exist.");
            }
            try {
                stmt.executeUpdate("DROP TABLE Rooms");
            }catch(Exception e) {
                System.out.println("Could not drop table room, room table does not exist.");
            }

            stmt.executeUpdate("CREATE TABLE Ingredients ("
                    + "id INTEGER PRIMARY KEY, "
                    + "name VARCHAR(255), "
                    + "quantity INTEGER)");

            stmt.executeUpdate("CREATE TABLE Utencils ("
                    + "id INTEGER PRIMARY KEY, "
                    + "name VARCHAR(255), "
                    + "is_available boolean)");
            stmt.executeUpdate("CREATE TABLE Players ("
                    + "id INTEGER PRIMARY KEY, "
                    + "name VARCHAR(225), "
                    + "score INT)");
            stmt.executeUpdate("CREATE TABLE Quests ("
                    + "id INTEGER PRIMARY KEY, "
                    + "name VARCHAR(255), "
                    + "objectives VARCHAR(1000), "
                    + "rewards VARCHAR(500))");

            stmt.executeUpdate("INSERT INTO Ingredients VALUES (1, 'Tomatoes', 5)");
            stmt.executeUpdate("INSERT INTO Ingredients VALUES (2, 'Cilantro', 6)");

            stmt.executeUpdate("INSERT INTO Utencils VALUES (1,'Spantula', true)");
            stmt.executeUpdate("INSERT INTO Utencils VALUES (2,'Tongs', true)");

            stmt.executeUpdate("INSERT INTO Players VALUES (1, 'Chuck', 200)");
            stmt.executeUpdate("INSERT INTO Players VALUES (2, 'Larry', 100)");

            stmt.executeUpdate("INSERT INTO Quests VALUES (1, 'Cook Steak', 'Gather all the ingredients and cook a steak.', 'Golden Spatula')");

            //String userInput = "Elsa'DROP TABLE * '";

            ResultSet rs = stmt.executeQuery("select id, "
                    + "								  name, "
                    + "								score"
                    + "							from Players");
            //+ "							where name = '" + userInput + "'");

            //scaryDelete(conn, "Elsa");

            // SQL Injection
            //scaryDelete(conn, "any' or 1 = ;1 or name='any");
            safeDelete(conn, "any' or 1 = 1 or name='any");

            while(rs.next()) {
                System.out.println("Player Name: " + rs.getString("name"));
                System.out.println("Score:" + rs.getString("score"));
                System.out.println(rs.getInt(1));
            }

        }catch(SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }catch(Exception e) {

        }finally {

        }
    }

    private static void scaryDelete(Connection conn, String name) throws SQLException{

        Statement stmt = conn.createStatement();
        String sql = "delete from animal "
                + "where name = '" + name + "'";
        System.out.println(sql);

        stmt.executeUpdate(sql);

    }

    private static void safeDelete(Connection conn, String name) throws SQLException{

        PreparedStatement ps = conn.prepareStatement("delete from Players "
                + "where name = ?");

        ps.setString(1, name);

        System.out.println(ps.toString());

        ps.execute();

    }


}