package db1.pattern1;

public class MyStoppableThread extends Thread {

    private boolean cancelToken = false;

    public void stopMe() {
        cancelToken = true;
    }

    public void close() {
        // cleanup
    }

    @Override
    public void run() {
        int work = 100;
        while (work < 1_000_000 && !cancelToken) {
            // long operation
            try {

                Thread.sleep(1000);
                work++;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        close();
    }
}
