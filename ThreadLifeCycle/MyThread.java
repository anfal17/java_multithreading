package ThreadLifeCycle;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("t1 running ");
        try {
            Thread.sleep(2000);
            System.out.println("T1 after sleep");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main (String[] args) throws InterruptedException  {
        MyThread t1 = new MyThread();
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        System.out.println("Main Thread state " + Thread.currentThread().getState());

        try {
            Thread.sleep(1000);

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(t1.getState());
        //main waits for t1 to get finished
        t1.join(); 
        System.out.println(t1.getState());
    }
}
