package hw.solution;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyUtils {

    public static void remove_last_item( Queue<Integer> myQueue) {
        // pass the key
        myQueue.remove();
    }

    public static void remove_last_item(ConcurrentLinkedQueue<Integer> myConcurrentQueue) {
        myConcurrentQueue.remove();
    }

}
