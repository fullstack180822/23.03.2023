package hw.solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {


    static Queue<Integer> myQueue = new ArrayDeque<>();

    static ConcurrentLinkedQueue<Integer> myConcurrentQueue = new ConcurrentLinkedQueue<>();

    private static void addItemToConcurrent(Integer item) {
        myConcurrentQueue.add(item);
    }

    private static void removeItemFromConcurrent() {
        myConcurrentQueue.remove();
    }

    private static synchronized void addItem(Integer item) {
        myQueue.add(item);
    }

    private static synchronized void removeItem() {
        myQueue.remove();
    }

    public static void main(String[] args) {

            int[] ints = new int[100];

            MyThread t1 = new MyThread("thread-1", ints);

            myQueue.add(1); // without lock

            ArrayList<Integer> list1 = new ArrayList<>();
            var result1 =  list1.stream().filter((x -> x > 10));
            // ......
            list1.add(100);

            long count = result1.count();

            Thread t = new Thread();
            t.start();


    }

}
