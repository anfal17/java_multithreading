package Locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class BankAccount {

    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " proceeding to withdraw " + amount);
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        Thread.currentThread().interrupted();
                    }finally{
                        lock.unlock();
                    }


                    balance -= amount;
                    System.out.println(
                            Thread.currentThread().getName() + " completed withdrawal remainging balance " + balance);
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficiet balance " + amount);
                }
            }else{
                System.out.println(Thread.currentThread().getName() + " could not acquire lock, will try later ");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupted();
        }
    }

    // ------------------using synchronized---------------
    // public synchronized void withdraw(int amount){
    // System.out.println(Thread.currentThread().getName() + " attempting to
    // withdraw "+amount);

    // if(balance >= amount){
    // System.out.println(Thread.currentThread().getName() + " proceeding to
    // withdraw "+amount);
    // try {
    // Thread.sleep(3000);
    // } catch (Exception e) {
    // // TODO: handle exception
    // }
    // balance -= amount;
    // System.out.println(Thread.currentThread().getName() + " completed withdrawal
    // remainging balance " + balance);
    // }else{
    // System.out.println(Thread.currentThread().getName() + " insufficiet balance
    // "+amount);
    // }
    // }
}
