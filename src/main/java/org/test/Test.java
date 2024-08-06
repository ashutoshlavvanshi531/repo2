package org.test;

import org.demo.Main;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        Test main = new Test();


//        main.subArrayCheck();
//        main.subArraySum();
//        main.kadansAlgo();
//        main.minimumJumps();
//        main.arrayIntersection();
        main.kadansAlgorithm();


    }

    public void kadansAlgorithm(){

        int[] ar = {-2,-3,4,-1,-2,1,5,-3};

        int left = 0;
        int right = 1;
        int maxSum = ar[0];
        int sum = ar[0];
        // sum, maxSum,
        // if sum < 0 if ar[i] > sum = ar[i]

        while (right < ar.length){

//            int[] ar = {-2,-3,4,-1,-2,1,5,-3};
            System.out.println("sum + ar[rigth] "+(sum + ar[right]));
            if ((sum + ar[right]) >= 0){
                System.out.println("right "+ar[right]);
                sum += ar[right];
                System.out.println("sum "+sum);
            }
            else{
                if (ar[right] > maxSum){
                    maxSum = ar[right];
                }
                else{
                    sum = ar[right+1];
                }
            }
            if (sum > maxSum) maxSum = sum;
            ++right;
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
