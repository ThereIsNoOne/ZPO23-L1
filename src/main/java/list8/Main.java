package list8;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SharedBank bank = new SharedBank(300);

        Thread first = new Thread(() -> run(bank, 30, 13));
        Thread second = new Thread(() -> run(bank, 34, 50));

        first.start();
        second.start();

        first.join();
        second.join();

        System.out.printf("Balance: %d\n", bank.getBalance());

        SharedBank synchronizedBank = new SharedBank(300);

        Thread synchronizedFirst = new Thread(() -> synchronizedRun(synchronizedBank, 30, 13));
        Thread synchronizedSecond = new Thread(() -> synchronizedRun(synchronizedBank, 34, 50));

        synchronizedFirst.start();
        synchronizedSecond.start();

        synchronizedFirst.join();
        synchronizedSecond.join();

        System.out.printf("Balance: %d\n", synchronizedBank.getBalance());
    }

    private static void run(SharedBank bank, int withdraw, int pay) {
        int i = 0;
        while (i < 10) {
            if (i % 2 == 0) {
                bank.withdraw(withdraw);
            } else {
                bank.pay(pay);
            }
            try {
                sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }
    }

    private static void synchronizedRun(SharedBank bank, int withdraw, int pay) {
        int i = 0;
        while (i < 10) {
            if (i % 2 == 0) {
                bank.withdrawSynchronized(withdraw);
            } else {
                bank.paySynchronized(pay);
            }
            try {
                sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }
    }
}
