package com.company;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;


/*
PROBLEM STATEMENT :: 
Write a function 'howSum(target,int [] num)'  that takes in a target sum and an array of numbers as argument
The function should return an Array containing any combination of the elements that adds ups to exactly the 'targetSum'
if there is no combination then return null.
if there are multiple combinations then return any single one

 */

public class HowSum {

    public Stack<Integer> howSum(int target, int [] a, HashMap<Integer, Stack<Integer>> memo){
        Stack<Integer> result;
        if(memo.containsKey(target)){
            return memo.get(target);
        }
        if(target == 0){
            return new Stack<>();
        }
        if(target < 0 ){
            return null;
        }
        for(int i=0;i<a.length;i++){
            result=howSum(target-a[i],a,memo);
            if( result != null){
                result.push(a[i]);
                memo.put(target,result);
                return memo.get(target);
            }
        }
        memo.put(target,null);
        return null;
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
        System.out.println("Enter target sum : ");
        int target =sc.nextInt();
        HowSum b=new HowSum();
        HashMap<Integer,Stack<Integer>> memo =new HashMap<>();
        Stack<Integer> answer;
        answer=b.howSum(target,a,memo);
        int i=1;
        if(answer != null){
            while (!answer.isEmpty()){
                System.out.println(answer.pop()+"   i = "+i++);
            }
            System.out.println();
        }
        else {
            System.out.println("null");
        }
    }
}

//Brute force
// time - O(n^m)  (when using stack)
//time - O((n^m)*(m) )  (when using ArrayList<>())
//space - O(m)

//Memoized
//time- O(n*m)
//Space- O(m*m)  // because we used extra space for the HashMap and each stack in the HashMap can have maximum of 'm' elements
