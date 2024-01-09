package list8;

public class Counter {

    private int counter;

    public int getSynchCounter() {
        return synchCounter;
    }

    private int synchCounter;

    public Counter() {
        counter = 0;
        synchCounter = 0;
    }

    public void increment() {
        counter++;
    }

    public synchronized void incrementSynchronized() {
        synchCounter++;
    }


    public int getCounter() {
        return counter;
    }
}
