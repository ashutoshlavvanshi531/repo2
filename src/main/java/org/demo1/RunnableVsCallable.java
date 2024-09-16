package org.demo1;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class RunnableVsCallable {
    public static void main(String[] args) {


        FutureTask<Integer> task = new FutureTask<>(new CallableClass());

        Thread t1 = new Thread(task);
        t1.start();

        try {
            task.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


    }
}

class RunnableClass implements Runnable{

    @Override
    public void run() {

//        throw new IOException();
    }
}

class CallableClass implements Callable<Integer>{

    boolean check = false;
    @Override
    public Integer call() throws IOException {
        return 0;
    }

    void test1() throws IOException{

    }
}
