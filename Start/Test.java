package Start;
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

        //with implements runnable
        HelloThread hello = new HelloThread();
        Thread thread = new Thread(hello);
        thread.start();

        for( ; ; ){
            System.out.println("Main thread");
        }
    }
}