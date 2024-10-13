package Syncronization;

public class BankAccount {

    private int balance = 100;


    //only one thread can acess this at a time afte the current thread competes the execeution
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw "+amount);

        if(balance >= amount){
            System.out.println(Thread.currentThread().getName() + " proceeding to withdraw "+amount);
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal remainging balance " + balance);
        }else{
            System.out.println(Thread.currentThread().getName() + " insufficiet balance "+amount);
        }
    }
}
