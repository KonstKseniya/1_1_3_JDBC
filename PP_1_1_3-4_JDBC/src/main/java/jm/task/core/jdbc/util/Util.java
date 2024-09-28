package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private final static String URL = "jdbc:mysql://localhost:3306/my_db";
    private final static String USER = "root";
    private final static String PASSWORD = "24Lol81kek91!";
    private static Connection connection;

    private Util() {

    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (connection != null) {
                System.out.println("Соединение с базой данных установлено");
                return connection;
            } else {
                throw new SQLException("Ошибка при установке соединения с базой данных");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Соединение с базой данных закрыто");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при закрытии соединения с базой данных", e);
        }
    }
}
