package list8;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Ex1 {


    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Ex1 ex1 = new Ex1();
        Thread first = new Thread(() -> {
            try {
                ex1.count(10_000, counter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread second = new Thread(() -> {
            try {
                ex1.count(10_000, counter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread third = new Thread(() -> {
            try {
                ex1.count(10_000, counter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        first.start();
        second.start();
        third.start();
//        fourth.start();

        first.join();
        second.join();
        third.join();
//        fourth.join();

        System.out.printf("Non volatile: %d, volatile: %d", counter.getCounter(), counter.getSynchCounter());
    }

    private void count(int n, Counter counter) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // Comment out to see synchronized vs. unsynchronized
            System.out.printf("i: %d, from thread %s\n", i, currentThread().getName());
            sleep(20);
            counter.increment();
            counter.incrementSynchronized();
        }
    }

}
