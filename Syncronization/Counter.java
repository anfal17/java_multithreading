package Syncronization;

//synchronized used to control correct access of shared data
//critical section ko manage karne kae liyae
//wrong value is read so result is unpredicted
//bcouz in race contion mulitple threads acess concurrently
//mutual exclusion - only 1 can access

public class Counter {
    private int count = 0;

    public synchronized void increment(){
        //if many objects of counter are there only that particular thread ,only once its accessed
        synchronized(this){
            count++;

        }
    }

    public int getCount(){
        return count;
    }
}

//syncronised used to stop an dcontrol race condtion
