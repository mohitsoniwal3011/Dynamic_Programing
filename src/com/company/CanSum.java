package com.company;

import java.util.HashMap;
import java.util.Scanner;

/*
PROBLEM STATEMENT ::

We are given an array of numbers and an integer targetSum we have to write a function which returns true of false
based of whether the target sum can be generated using the elements of the array or not

we can take the following assumptions:
1. we may use an element of the array as many times as needed
2. we may assume that all the input numbers in the array are non-negative
 */

public class CanSum {

    public static boolean canSum(int target,int [] a,HashMap<Integer,Boolean>  memo){
        if(memo.containsKey(target) ){
            return memo.get(target);
        }
        if(target < 0){
            return false;
        }
        if(target == 0){
            return true;
        }
        for(int i=0;i<a.length;i++){
            if(canSum(target-a[i],a,memo)){
                memo.put(target,true);
                return true;
            }
        }
        memo.put(target,false);
        return false;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc =new Scanner(System.in);
       System.out.println("Enter number of elements: ");
        n=sc.nextInt();
        int [] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=i+1;
        }
        System.out.println("Enter the array: ");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        HashMap<Integer,Boolean> memo=new HashMap<>();
        System.out.println("Enter target sum : ");
        int target =sc.nextInt();
        System.out.println(canSum(target,a,memo));

    }
}
