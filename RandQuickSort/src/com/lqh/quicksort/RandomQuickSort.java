package com.lqh.quicksort;

import java.util.Random;

public class RandomQuickSort {
    public static int MAXN=20;
    public static int first=0,last=MAXN-1;
    public static int [] arr= new int[MAXN];
    public static void main(String[] args) {
        fillRandArray();
        printArray();
        quickSort(first,last);
        System.out.println();
        printArray();
    }
    public static void fillRandArray() {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=r.nextInt(20);
        }
    }
    public static void printArray() {
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
    public static void quickSort(int first, int last) {
        if(first>=last)
            return;
        int left=first,right=last;
        Random r = new Random();
        int randIndex = r.nextInt(last-first+1) + first;
        int num=arr[randIndex];
        if(arr[left]!=num)
            swap(arr,left,randIndex);
        int i=left;
        while (i<=right) {
            if(arr[i]<num){
                swap(arr,i++,left++);
            }else if(arr[i]==num){
                i++;
            }else{
                swap(arr,i,right--);
            }
        }
        quickSort(first,left-1);
        quickSort(right+1,last);
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
