package org.demo1;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 10;
    private int[] array;
    private int start,end;


    public SumTask(int[] array, int start, int end){
        this.array = array;
        this.start = start;
        this.end = end;
    }

// group by key ->


    @Override
    public Integer compute(){

        if (end - start < THRESHOLD){
            int sum = 0;
         return    processing();

        }
        else {

            int mid = start + (start+end)/2;
            SumTask task1 = new SumTask(this.array,this.start,mid);
            SumTask task2 = new SumTask(this.array, mid, this.end);

            task1.fork();
            int result2 = task2.compute();
            int result1 = task1.join();

            return result1 + result2;
        }
    }

    public Integer processing(){
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
}
