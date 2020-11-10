package sql;

import java.sql.*;

public class MySQLAccess {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private String dbHost;
    private int dbPort;
    private String dbName;
    private String dbUsername;
    private String dbPassword;
    private Connection conn;

    public MySQLAccess(String dbHost, int dbPort, String dbName, String dbUsername, String dbPassword) {
        this.dbHost = dbHost;
        this.dbPort = dbPort;
        this.dbName = dbName;
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
        this.conn = null;
    }

    public boolean setDBConnection() {
        try {
            Class.forName(DRIVER);
            String url = "jdbc:mysql://" + dbHost +":" + dbPort + "/";
            try {
                conn = DriverManager.getConnection(url+dbName, dbUsername, dbPassword);
            } catch (SQLException e) {
                System.out.println("Connection to database failed");
                close();
                return false;
            }
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("No jdbc.Driver class found");
            close();
            return false;
        }

    }

    public boolean isDBConnected() {
        try {
            return conn != null && conn.isValid(5);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet query(String sql) throws SQLException {
        if (!isDBConnected()) {
            if (!setDBConnection()) {
                throw new SQLException("Connection to database failed!");
            }
        }
        Statement st = conn.createStatement();
        return st.executeQuery(sql);
    }


    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
