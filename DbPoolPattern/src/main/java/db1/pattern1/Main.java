package db1.pattern1;

public class Main {

    public static void main(String[] args) throws InterruptedException {

    }

    private static void insertCustomer() throws InterruptedException {
        MyDbConnection conn =  ConnectionPool.getInstance().getConnection();

        try {
            // conn.Insert
        }
        finally {
            ConnectionPool.getInstance().returnConnection(conn);
        }
    }
}
