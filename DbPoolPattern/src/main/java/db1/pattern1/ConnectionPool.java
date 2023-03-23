package db1.pattern1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectionPool implements IConnectionPool {

    final static int max = 40;
    final static Object key = new Object();
    final static Object pool_key = new Object();
    private static ConnectionPool INSTANCE = null;

    Queue<MyDbConnection> connections = new LinkedList<MyDbConnection>();

    private ConnectionPool() {
        for (int i = 0; i < max; i++) {
            connections.add(new MyDbConnection());
        }
    }

    @Override
    public MyDbConnection getConnection() throws InterruptedException {
        synchronized (pool_key) {
            while (connections.size() == 0) {
                pool_key.wait();
                // return here after notify
            }

            MyDbConnection conn = connections.remove();
            return conn;
        }
    }

    @Override
    public void returnConnection(MyDbConnection conn) {
        synchronized (pool_key) {
            connections.add(conn);
            pool_key.notifyAll();
        }
    }

    @Override
    public void close() {
        synchronized (pool_key) {
            for (MyDbConnection conn : connections) {
                try {
                    conn.close();
                }
                catch (Exception ex) {

                }
            }
            while (connections.size() > 0) {
                try {
                    connections.remove();
                }
                catch (Exception ex) {

                }
            }
        }
    }

    public static ConnectionPool getInstance() {
        if (INSTANCE == null ){
            synchronized (key) {
                if (INSTANCE == null) {
                    INSTANCE = new ConnectionPool();
                }
            }
        }

        return INSTANCE;
    }

}
