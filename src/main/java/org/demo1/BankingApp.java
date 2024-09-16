package org.demo1;

import java.util.Optional;

public class BankingApp {

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(10000);
        BankAccount acc2 = new BankAccount(7000);

        new Thread(()-> acc1.transfer(acc2,1000),"User1").start();
        new Thread(()-> acc2.transfer(acc1,1600),"User2").start();



        int number = 10; // effectively final
        Runnable runnable = () -> {System.out.println(number);

        };

        Optional<Integer> obj = Optional.of(10);


        runnable.run();

    }

}
