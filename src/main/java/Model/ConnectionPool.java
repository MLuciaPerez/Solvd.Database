package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectionPool {

    private static ConnectionPool instance;
    private final Queue<Connection> connectionPool = new LinkedList<>();
    private static final int MAX_POOL_SIZE = 10;
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/clinicdb";
    private static final String USER = "root";
    private static final String PASSWORD = "12342024";

    private ConnectionPool() {
        // Para crear las conexiones y agregarlas al pool
        try {
            for (int i = 0; i < MAX_POOL_SIZE; i++) {
                connectionPool.add(DriverManager.getConnection(URL, USER, PASSWORD));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public synchronized Connection getConnection() {
        if (connectionPool.isEmpty()) {
            throw new RuntimeException("No available connections in the pool");
        }
        return connectionPool.poll();
    }

    public synchronized void releaseConnection(Connection connection) {
        connectionPool.offer(connection);
    }
}