package org.demo1;

public class EvenOddThreads {
    public static void main(String[] args) {

        Thread t1 = new Thread(new ThreadImpl(),"Odd");
        Thread t2 = new Thread(new ThreadImpl(),"Even");

        t1.start();
        t2.start();

    }


}
    class ThreadImpl implements Runnable {

        volatile int count = 1;
        private final int maxCount = 20;

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" started..");
            if (count % 2 == 0) {
                try {
                    printEvenNumber();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    printOddNumber();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        private synchronized void printOddNumber() throws InterruptedException {
            while (count <= maxCount) {
                while (count % 2 == 0) {
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + " : " + (count));
                ++count;
                notify();

            }
        }

        private synchronized void printEvenNumber() throws InterruptedException {
            while (count <= maxCount) {
                while (count % 2 != 0) {
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + " : " + count);
                ++count;
                notify();
            }

        }
}
