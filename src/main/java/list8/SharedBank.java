package list8;

import static java.lang.Thread.sleep;

public class SharedBank {
    private int balance;

    public SharedBank(int balance) {
        this.balance = balance;
    }

    public boolean withdraw(int amount) {
        if (amount >= balance) {
            balance -= amount;
            try {
                sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        return false;
    }


    public boolean pay(int amount) {
        balance += amount;
        try {
            sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

        public synchronized boolean withdrawSynchronized(int amount) {
        if (amount >= balance) {
            balance -= amount;
            try {
                sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        return false;
    }


    public synchronized boolean paySynchronized(int amount) {
        balance += amount;
        try {
            sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public int getBalance() {
        return balance;
    }
}
