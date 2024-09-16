package org.demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private double balance;
    private final Lock lock = new ReentrantLock();


    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }

    public double getBalance(){
        return this.balance;
    }

    public void deposit(double amount){
        lock.lock();
        try {
            this.balance += balance;
            System.out.println(Thread.currentThread().getName()+" deposited amount "+amount);
        }
        finally {
            lock.unlock();
        }
    }

    public void transfer(BankAccount targetAccount, double amount){
        lock.lock();
        try {
            if (this.balance > amount){
                this.balance -= amount;
                targetAccount.deposit(amount);
                System.out.println(Thread.currentThread().getName()+" transferred "+amount+" to "+targetAccount);

            }
            else{
                System.out.println("Oops!! insufficient balance..!!");
            }
        }
        finally {
        lock.unlock();
        }
    }
}
