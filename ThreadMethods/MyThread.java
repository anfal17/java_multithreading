package ThreadMethods;

//Thread Methods
//run
//start
//sleep
//join
//setPriority  - - -def- 5, min,norm,max
// - ---- - - -namin the thread using the constructor
//interrupt
//yield - give chace to other threads
//Daemon threads - JVM doesnt wait for these

public class MyThread extends Thread {

    MyThread(String name){
        super(name);
    }
    
    // @Override
    // public void run() {
    //     try {
    //         Thread.sleep(3000);
    //         System.out.println("After 1s");
    //     } catch (Exception e) {
    //         throw new RuntimeException(e);
    //     }
    // }

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            //doing heavy operation so that we can observe the thread sexecution sequence
            String a = "";
            for (int j = 0; j < 100000000; j++) {
                a += "";
            }
            System.out.println(Thread.currentThread().getName() + " - Priority : "+ Thread.currentThread().getPriority()+ " -count - : "+i);
            try{
                Thread.sleep(10);
            }catch(Exception e){
            }


        }
    }

    public static void main(String[] args) throws InterruptedException {
        // MyThread t1 = new MyThread();
        // t1.start();
        // t1.join();
        // //main waits for t1 and then executes the below code
        // System.out.println("Hello");

        //-------------Priority----------------
        //naming the thread
        MyThread h = new MyThread("High Priority Thread");
        MyThread m = new MyThread("Medium Priority Thread");
        MyThread l = new MyThread("Low Priority Thread");

        l.setPriority(Thread.MIN_PRIORITY);
        m.setPriority(Thread.NORM_PRIORITY);
        h.setPriority(Thread.MAX_PRIORITY);

        l.start();
        m.start();
        h.start();
    }

}
