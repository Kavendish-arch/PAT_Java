package com.chen.exercise;

import java.util.Random;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT_Java
 * @package com.chen.exercise
 * @className com.chen.exercise.ExerciseTransfer
 * @date 2025/4/20 22:18
 * @description @todo
 */
public class ExerciseTransfer {
    public static void main(String[] args) {
        Account account1 = new Account(1000);
        Account account2 = new Account(1000);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                account1.transformer(account2, getRandom());
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                account2.transformer(account1, getRandom());
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());

//        System.out.println("转账完成");
        if (account1.getBalance() + account2.getBalance() == 2000)
            System.out.println("转账成功");
        else
            System.out.println("转账失败");
    }

    static Random random = new Random();

    public static int getRandom() {
        return random.nextInt(5) + 1;
    }
}

class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // 转账
    public synchronized void transformer(Account account, int amount) {
        if (this.balance >= amount) {
            this.setBalance(this.balance - amount);
            account.setBalance(account.getBalance() + amount);
        }
    }
//    public void transformer(Account account, int amount) {
//        synchronized (Account.class) {
//            if (this.balance >= amount) {
//                this.setBalance(this.balance - amount);
//                account.setBalance(account.getBalance() + amount);
//            }
//        }
//    }
}
