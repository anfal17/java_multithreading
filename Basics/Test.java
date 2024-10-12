package Basics;
//main thread is the first thread

/**
 * Test
 */
public class Test {
    public static void main(String[] args) {
        // System.out.println(Thread.currentThread().getName());
        
        //with extends thread
        // HelloThread hello = new HelloThread();
        //hello.start();

        //use runnable whenever a class is already extended and you can only implement it
        //due to multiple inheritance

        //with implements runnable
        HelloThread hello = new HelloThread();
        Thread thread = new Thread(hello);
        thread.start();

        for( ; ; ){
            System.out.println("Main thread");
        }
    }
}