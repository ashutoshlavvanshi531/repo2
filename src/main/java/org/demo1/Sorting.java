package org.demo1;

public class Sorting {
    public static void main(String[] args) {
        Sorting main = new Sorting();

        main.sortUsingQuickSort();
    }


    public void sortUsingQuickSort(){

        int[] ar = {44,85,1,58,17,97,53,52,7,49,9,64,2,45,21,95};


        int pivot = 0;
        ar = quickSort(ar,0,ar.length-1, pivot);

        for (int value: ar) {
            System.out.print(value+" ");
        }

    }

    public int[] quickSort(int[] ar,int low,int high,int pivot){

        //while low < length and high >=0
        // if high < low swap(low, high)
        // if high>=0 and low< length swap




        if (high <= low) return ar;

//        int low = ar[1];
//        int high = ar[ar.length-1];


        while (high >= low) {

            while (low<ar.length && ar[low] <= ar[pivot]) {
                low++;
            }

            while (high >0 && ar[high] >= ar[pivot]) {
                high--;
            }

            if (low < high) {
                swap(ar,low,high);
            }
        }


        swap(ar,pivot,high);

        ar = quickSort(ar,pivot,high-1,pivot);
        ar = quickSort(ar,high+1,ar.length-1,pivot);

        return ar;
    }

    public void swap(int[] ar,int left, int right){
        int temp = ar[left];
        ar[left] = ar[right];
        ar[right] = temp;
    }
}
