package login;

import java.sql.*;
import sql.MySQLAccess;

public class LoginAuth {
    public static boolean validate(String username, String password) {
        MySQLAccess con = new MySQLAccess("127.0.0.1", 3306, "login", "root", "password");

        String sql = "SELECT * FROM login.user WHERE username = '" + username + "' AND password = '" + password + "';";

        try {
            ResultSet result = con.query(sql);
            boolean success = result.next(); // check if it is non empty return result
            con.close();

            return success;
        } catch (SQLException ex) {
            System.out.println("Failed to query the database.");
            con.close();
            ex.printStackTrace();
            return false;
        }
    }
}
