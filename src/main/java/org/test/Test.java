package org.test;

import org.demo.Main;
import org.demo1.SumTask;

import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class Test {




    public static void main(String[] args) {
        Test main = new Test();












//        main.numberOfChocolates();
//        main.subArrayCheck();
//        main.subArraySum();
//        main.kadansAlgo();
//        main.minimumJumps();
//        main.arrayIntersection();
//        main.kadansAlgorithm();
//        main.rightShiftByTwoPlaces();
//        main.threeSumBrute();
//        main.moveZerosTowardsEnd();
//        main.moveZerosTowardsEndWithInsertionOrder();

    }

    public void testString(String str){
        str = str+" Lavvanshi";
    }

    public void testArray(int[] ar){

        int temp = ar[0];
        ar[0] = ar[1];
        ar[1] = temp;
        return;
    }

    public void numberOfChocolates(){


        int chocolates = 16;
        int price = 2;

        int initialChocolates = chocolates/price;

        int totalChocolates = buyChocolatesFromRapper(initialChocolates);

        System.out.println("Total chocolates can be bought are .. "+totalChocolates);

    }

    public int buyChocolatesFromRapper(int initialChocolates){
        if (initialChocolates <  1) return 0;
        return initialChocolates + buyChocolatesFromRapper(initialChocolates/2);
    }

    public void forkJoinPoolProcessing(){

        int[] userData = new int[100]; // Simulated user data
        for (int i = 0; i < userData.length; i++) {
            userData[i] = i + 1; // Fill with sample data
        }
        Main main = new Main();

        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(userData,0,userData.length);
        int result = pool.invoke(task);


    }

    public void moveZerosTowardsEndWithInsertionOrder(){
//        int[] ar = {2, 0, 3, 0, 1, 0, 4, 0, 5};
        int[] ar = {0, 1, 0, 3, 12, 0, 5};

        // if startingIndex value is zero
        // then start
        System.out.println("Keeping the insertion order preserved while moving zeros to end...1");
        int ptr1 = 0;
        int ptr2 = ptr1;

       while (ar[ptr1] != 0){
           ptr1++;
       }
       ptr2 = ptr1+1;

        while (ptr2 < ar.length){

            if (ar[ptr2] != 0 ){
                ar[ptr1++] = ar[ptr2];
                ar[ptr2] = 0;
            }
            ptr2++;
        }

        for (int value: ar)
            System.out.print(" "+value);
    }

    public void moveZerosTowardsEnd(){
        int[] ar = {2, 0, 3, 0, 1, 0, 4, 0, 5};

        int index = 0;
        int zerosPos = ar.length-1;

        while (ar[zerosPos] == 0){
            zerosPos--;
        }
        while (index < zerosPos){
            if (ar[index] == 0){
                int temp = ar[index];
                ar[index] = ar[zerosPos];
                ar[zerosPos--] = 0;
                while (ar[zerosPos] == 0){
                    zerosPos--;
                }
            }
            index++;
        }

        for (int value: ar){
            System.out.print(" "+value);
        }
    }


    public void threeSumBetter(){
        int[] ar = {4, -4, 2, -2, 0, 0, 1, -1};
        int targetSum = 0;

        for (int i=0; i<ar.length-2; i++){
            int sum = ar[i] + ar[i+1];
            for (int j = i+1; j < ar.length-1; j++) {

            }
        }
    }
    public void threeSumBrute(){

        int[] ar = {4, -4, 2, -2, 0, 0, 1, -1};
        int targetSum = 0;
        for (int i=0; i<ar.length-2; i++){
            for (int j = i+1; j < ar.length-1; j++) {
                for(int k = j+1; k < ar.length; k++) {
                    if (ar[i]+ar[j]+ar[k]==targetSum)
                    {
                        System.out.println(ar[i]+" "+ar[j]+" "+ar[k]);
                        return;
                    }
                }
            }
        }
    }

    public void test(){
        int ar[] = {1,2,3,4,5};
        int k = 2;
        int n = ar.length;
        int temp[] = new int[ar.length];
        for (int i=0; i<k; i++){
            {
                temp[i] = ar[n-k+i];
            }
        }

        for (int i = k; i < n; i++) {
            temp[i] = ar[i-k];
        }

        for (int value: temp)
            System.out.println(value);
    }

    public void rightShiftByTwoPlaces(){

        System.out.println("Rotate array to the right by k places");
        int ar[] = {1,2,3,4,5};

        int k = 2;
        int n = ar.length;


//        ar = reverse(ar,0,n-1);
//        ar = reverse(ar, 0, n-k-1);
//        ar = reverse(ar,n-k, n-1);


        ar = reverse(ar, 0, n-k-1);
        ar = reverse(ar,n-k, n-1);
        ar = reverse(ar,0,n-1);

        for (var value: ar){
            System.out.print(" "+value);
        }

    }

    public int[] reverse(int[] ar,int start, int end){

        while(start<end){

            int temp = ar[start];
            ar[start++] = ar[end];
            ar[end--] = temp;
        }
        return ar;
    }

    public void kadansAlgorithm(){

        int[] ar = {-2,-3,4,-1,-2,1,5,-3};

        int sum = 0;
        int maxSum = ar[0];
        int right = 1;

        while (right < ar.length){
            sum = sum + ar[right];
            if (sum > maxSum){
                maxSum = sum;
            }
            if (sum < 0){
                sum = 0;
            }
            right++;
        }

        System.out.println("max sum value is "+maxSum);

    }
    public void arrayIntersection(){
//        int ar1[] = {1, 2, 2, 1};
//        int ar2[] = {2,2};
        int ar1[] = {4, 9, 5};
        int ar2[] = {9, 4, 9, 8, 4};

        List<Integer> list = new ArrayList<>();

        Collections.unmodifiableList(list);

        if (ar1.length > ar2.length) smallerSet(ar2,ar1);
        else smallerSet(ar1,ar2);
    }

    public void smallerSet(int[] ar1, int[] ar2){

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int value: ar1){
            set1.add(value);
        }
        for (int value: ar2){
            if (set1.contains(value)){
                set2.add(value);
            }
        }

        System.out.println(set2);

    }

    public void minimumJumps(){
        int ar[] =  {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
//        int ar[] =  {2, 3, 1, 1, 4};
//        int ar[] =  {3, 0, 2, 1, 0, 4};
        // start = 0,
        // loopSize = [index] <= index = ar[o]
        // max,maxIndex = from loop (cIndex + loopSize)
        // cIndex = cIndex+maxIndex , cIndex< array size

        int start = 0;
        int jump = 0;
        int cIndex = start;

        while ((cIndex+1) < ar.length) {

            int loopSize = ar[cIndex];
            int maxIndex = cIndex+1;
            int preMax = cIndex;
            int max = ar[maxIndex];

            for (int j = cIndex+1; j <= (cIndex+loopSize) && j<ar.length; j++) {
                if (ar[j] > max){
                    max = ar[j];
                    maxIndex = j;
                }
            }

            if (ar[cIndex]==0)
            {
                System.out.println("jump = -1");
                return;
            }
            cIndex = maxIndex;
            jump++;
        }
        System.out.println("Max jumps are "+jump);

    }


    public void kadansAlgo(){
//        int ar[] = {1, 2, 3, -2, 5};
//        int ar[] = {-1, -2, -3, -4};
        int ar[] = {5, 4, 7};

        int l =0, r=1;
        int sum = ar[l];
        int max = sum;


        while( r<ar.length ){

            sum += ar[r++];

            if (sum < 0){
                l++;
                r = l+1;
                if (ar[l] > max){
                    max = ar[l];
                }
            }
            if(sum > max){
               max = sum;
            }
        }

        System.out.println("Max sum is "+max);

    }
    public void subArraySum(){
        int ar[] = {1,2,3,7,5};

        int s = 15;

        int l = 0;
        int r = 1;

        if (ar[l] == s){
            System.out.println("sum found "+ar[l]);
        }

        int sum = ar[l];
        while( r < ar.length ){

            sum += ar[r++];
            if (sum == s){
                System.out.println("indeces are "+l+" and "+(--r));
                return;
            }
            else if (sum > s){
                ++l;
                r = l+1;
                sum = ar[l];
                if (ar[l]==s) {
                    System.out.println("sum found at "+l);
                    return;
                }
            }
        }
    }
    public void subArrayCheck(){
        int[] ar1 = {2,3,0,5,1,1,2};

        int[] ar2 = {3,0,5,1};

        if(ar1.length < ar2.length) checkIfSubArrayExist(ar1,ar2);
        else checkIfSubArrayExist(ar2,ar1);
    }

    public void checkIfSubArrayExist(int ar1[],int ar2[]){

        int k = ar1.length;
        for(int i = 0; i <= ar2.length - ar1.length; i++) {
            for (int j = 0; j < ar1.length; j++) {
                if(ar1[j] == ar2[i+j]){
                    k--;
                }
                else {
                    System.out.println("k value is "+k);
                    k = ar1.length;
                    break;
                }
            }
            if (k==0) break;
        }

        System.out.println("value of k is "+k);
        if (k==0) {
            System.out.println("Yes sub array exists");
        }
    }
}
