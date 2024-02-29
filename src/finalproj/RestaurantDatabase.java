package finalproj;

import java.sql.*;

import org.apache.derby.jdbc.EmbeddedDataSource;

public class RestaurantDatabase {

    /**
     * Main method to create and fill database
     *
     * @throws Exception If an exception occurs during database operations.
     */
    public static void main(String[] args) throws Exception {
        try {
            EmbeddedDataSource ds = new EmbeddedDataSource();
            ds.setDatabaseName("restaurant_database");
            ds.setCreateDatabase("create");

            Connection conn = ds.getConnection();
            Statement stmt = conn.createStatement();

            System.out.println(conn);

            //drop tables if they exist
            try {
                stmt.executeUpdate("DROP TABLE Employees");
            } catch (Exception e) {
                System.out.println("Could not drop table employees, employees table does not exist.");
            }

            try {
                stmt.executeUpdate("DROP TABLE Transactions");
            } catch (Exception e) {
                System.out.println("Could not drop table transactions, transactions table does not exist.");
            }

            //create tables
            try {
                stmt.executeUpdate("CREATE TABLE Employees ("
                        + "id INTEGER PRIMARY KEY, "
                        + "name VARCHAR(255), "
                        + "position VARCHAR(255), "
                        + "salary DECIMAL(10,2))");

                stmt.executeUpdate("CREATE TABLE Transactions ("
                        + "id INTEGER PRIMARY KEY, "
                        + "description VARCHAR(255), "
                        + "amount DECIMAL(10,2))");

                //insert sample data
                stmt.executeUpdate("INSERT INTO Employees VALUES (1, 'Rick', 'Waiter', 45000)");
                stmt.executeUpdate("INSERT INTO Employees VALUES (2, 'Amanda','Waitress',45000)");
                stmt.executeUpdate("INSERT INTO Employees VALUES (3, 'Andrew', 'Bartender',50000)");

                stmt.executeUpdate("INSERT INTO Transactions VALUES (1,'Smith Family', 80)");
                stmt.executeUpdate("INSERT INTO Transactions VALUES (2,'Jefferson Family', 100)");
                stmt.executeUpdate("INSERT INTO Transactions VALUES (3,'Jackson Family', 200)");

                // give an employee a raise
                giveRaise(conn,1,5000);

                ResultSet rs = stmt.executeQuery("SELECT id, name, salary FROM Employees");

                while (rs.next()) {
                    System.out.println("Employee Name: " + rs.getString("name"));
                    System.out.println("Salary: " + rs.getString("salary"));
                    System.out.println("ID: " + rs.getInt("id"));
                }

            //prints error messages
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println(e.getSQLState());
                System.out.println(e.getErrorCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void safeDelete(Connection conn, String name) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM Employees WHERE name = ?")) {
            ps.setString(1, name);
            System.out.println(ps.toString());
            ps.execute();
        }
    }
    /**
     * Give a raise to an employee.
     *
     * @param conn       The database connection.
     * @param employeeId The ID of the employee to give a raise.
     * @param raiseAmount The amount of the raise.
     * @throws SQLException If a database error occurs.
     */
    public static void giveRaise(Connection conn, int employeeId, double raiseAmount) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("UPDATE Employees SET salary = salary + ? WHERE id = ?")) {
            ps.setDouble(1, raiseAmount);
            ps.setInt(2, employeeId);
            ps.executeUpdate();
        }
    }
}

