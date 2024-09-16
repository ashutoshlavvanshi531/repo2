package org.demo1;


import java.util.concurrent.CountDownLatch;

public class OrderProcessing {
    public static void main(String[] args) throws InterruptedException{
        int numberOfTasks = 4;

        CountDownLatch latch = new CountDownLatch(numberOfTasks);


        // 1. Validate order
        new Thread(new Task("Validate order",latch)).start();

        // 2. Process payment
        new Thread(new Task("Process payment",latch)).start();

        // 3. Update Inventory
        new Thread(new Task("Update inventory",latch)).start();

        // 4. Send confirmation mail
        new Thread(new Task("Confirmation mail",latch)).start();

        // Main thread waits until all tasks gets completed.

        latch.await();
        System.out.println("All tasks are completed. Now finalizing order processing...");
    }
}

class Task implements Runnable{

    private final String taskName;
    private final CountDownLatch latch;
    public Task(String taskName, CountDownLatch latch){
        this.taskName = taskName;
        this.latch = latch;
    }

    @Override
    public void run(){
        try{
            // Simulate task execution.
            System.out.println(taskName+" started..");
            Thread.sleep(500);
            System.out.println(taskName+" completed.");

        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        finally {
            latch.countDown();
        }
    }
}