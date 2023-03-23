package hw.solution;

public class MyThread extends Thread {

    protected int[] ints;

    public MyThread(String name, int[] ints) {
        super(name);
        this.ints = ints;
    }

}
