package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String url = "jdbc:mysql://192.168.212.38:3306/katafirst";
    private static final String user = "root";
    private static final String password = "R4e3w2q1";

    private static Connection conn = null;
    private static Util instance = null;

    private Util() {
        try {
            if (null == conn || conn.isClosed()) {
                conn = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Util getInstance() {
        if (null == instance) {
            instance = new Util();
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }
}
