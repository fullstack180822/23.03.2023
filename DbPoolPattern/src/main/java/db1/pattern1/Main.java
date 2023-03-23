package db1.pattern1;

import java.util.Objects;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        MyStoppableThread myStoppableThread = new MyStoppableThread();
        myStoppableThread.start();

        // ...

        myStoppableThread.stopMe();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                System.out.println(i);
            }
            // t2.join();  // t1 is waiting

        });
        t1.start();

        if (t1.getState() == Thread.State.TERMINATED) {
            //t1 = new Thread()
        }

        Thread.yield();
        Thread.sleep(1);

        t1.suspend();

        t1.resume();

        t1.stop();

        System.out.println(Thread.currentThread().getName());

        t1.join(); // wait here, blocking. till t1 is finished...
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
