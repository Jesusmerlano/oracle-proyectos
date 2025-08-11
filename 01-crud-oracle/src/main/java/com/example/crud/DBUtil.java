package com.example.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String DEFAULT_URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
    private static final String DEFAULT_USER = "app_user";
    private static final String DEFAULT_PASS = "app_password";

    public static Connection getConnection() throws SQLException {
        String url = System.getenv().getOrDefault("ORACLE_URL", DEFAULT_URL);
        String user = System.getenv().getOrDefault("ORACLE_USER", DEFAULT_USER);
        String pass = System.getenv().getOrDefault("ORACLE_PASSWORD", DEFAULT_PASS);
        return DriverManager.getConnection(url, user, pass);
    }
}
