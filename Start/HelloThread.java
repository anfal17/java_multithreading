package Start;

// public class HelloThread extends Thread {
//     @Override
//     public void run() {
//         for( ; ; ) {
//             System.out.println("Hello from HelloThread!");
//         }
//     }
// }

public class HelloThread implements Runnable {
    @Override
    public void run() {
        for( ; ; ) {
            System.out.println("Hello from HelloThread!");
        }
    }
}
