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
                stmt.executeUpdate("DROP TABLE quests");
            }catch(Exception e) {
                System.out.println("Could not drop table quests, quests table does not exist.");
            }

            stmt.executeUpdate("CREATE TABLE ingredients ("
                    + "id INTEGER PRIMARY KEY, "
                    + "name VARCHAR(255), "
                    + "quantity INTEGER)");

            stmt.executeUpdate("CREATE TABLE utencils ("
                    + "id INTEGER PRIMARY KEY, "
                    + "name VARCHAR(255), "
                    + "is_available boolean)");
            stmt.executeUpdate("CREATE TABLE players ("
                    + "name VARCHAR(225), "
                    + "score INT)");
            stmt.executeUpdate("CREATE TABLE quests ("
                    + "id INTEGER PRIMARY KEY, "
                    + "name VARCHAR(255), "
                    + "objectives VARCHAR(1000), "
                    + "rewards VARCHAR(500))");

            stmt.executeUpdate("INSERT INTO ingredients VALUES (1, 'Tomatoes', 5)");
            stmt.executeUpdate("INSERT INTO ingredients VALUES (2, 'Cilantro', 6)");

            stmt.executeUpdate("INSERT INTO utencils VALUES (1,'Spantula', true)");
            stmt.executeUpdate("INSERT INTO utencils VALUES (2,'Tongs', true)");

            stmt.executeUpdate("INSERT INTO players VALUES (1, 1, 'Ester', '2002-09-09 10:36:00')");
            stmt.executeUpdate("INSERT INTO players VALUES (2, 1, 'Eddie', '2010-06-08 01:24:00')");

            stmt.executeUpdate("INSERT INTO animal VALUES (5, 2, 'Zoe', '2005-11-12 03:44:00')");

            //String userInput = "Elsa'DROP TABLE * '";

            ResultSet rs = stmt.executeQuery("select id, "
                    + "							species_id, "
                    + "								  name, "
                    + "								date_born "
                    + "							from animal");
            //+ "							where name = '" + userInput + "'");

            //scaryDelete(conn, "Elsa");

            // SQL Injection
            //scaryDelete(conn, "any' or 1 = ;1 or name='any");
            safeDelete(conn, "any' or 1 = 1 or name='any");

            while(rs.next()) {
                System.out.println("Animal Name: " + rs.getString("name"));
                System.out.println("Date Born:" + rs.getString("date_born"));
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

        PreparedStatement ps = conn.prepareStatement("delete from animal "
                + "where name = ?");

        ps.setString(1, name);

        System.out.println(ps.toString());

        ps.execute();

    }


}