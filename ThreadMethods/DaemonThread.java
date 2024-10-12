package ThreadMethods;

public class DaemonThread extends Thread{
    
    DaemonThread(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Name of thread  "+Thread.currentThread().getName()+ " - "+i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        // DaemonThread t1 = new DaemonThread("User thread");
        // //JVM waits for user thread
        
        // //JVM doesnt wait for Daemon thread
        // //Exmaples of daemon thread - garbage collection aetc other threads
        // t1.start();
        // t1.yield();

        DaemonThread t2 = new DaemonThread("Daemon Thread");
        t2.setDaemon(true);

        t2.start();

        //main doesnt wiat until t2 is completed

        System.out.println("Main done");
    }
}
