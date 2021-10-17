package com.company;

import java.util.*;
/*
PROBLEM STATEMENT::

Write a function bestSum(targetSum,number) which takes targetSum and An array of integers 'number'
that adds up to exactly the targetSum

the function should return the shortest combination of numbers that adds up to
targetSum.If there is a tie for the shortest combination then program can return any one of the shortest
combination
 */

public class BestSum {
    public ArrayList<Integer> bestSum(int target,int [] a,HashMap<Integer,ArrayList<Integer>> memo){
        if(memo.containsKey(target)){  return memo.get(target);}
        if(target == 0){ return new ArrayList<>();}
        if(target < 0){ return null;}

        ArrayList<Integer> shortest=null,result;
        for(int i=0;i<a.length;i++){
            result =bestSum(target-a[i],a,memo);
            if(result != null){
                /*we can not directly add a[i] to result we got because result is referring to the shortest combination of the
                target=(target -a[i]) so adding something to result will make the shortest combination of (target -a[i]) incorrect and the
                program will ultimately return incorrect result so the trick here is to clone the object result into new object 'combination'
                and add a[i] to it */
                ArrayList<Integer> combination = (ArrayList<Integer>) result.clone();
                combination.add(a[i]);
                if(shortest == null || (combination.size() < shortest.size())){
                    //shortest= (ArrayList<Integer>) combination.clone(); //this can also be done
                    shortest=combination;
                }
            }
        }
        memo.put(target,shortest);
        return shortest;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n=sc.nextInt();
        int [] a=new int[n];
        System.out.println("Enter the array: ");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        System.out.println("Enter target sum : ");
        int target =sc.nextInt();
        BestSum b=new BestSum();
        HashMap<Integer,ArrayList<Integer>>  memo=new HashMap<>();
        ArrayList<Integer> shortest=b.bestSum(target,a,memo);
        if(shortest == null){
            System.out.println("null");
        }
        else {
            System.out.println("Shortest.size() = "+shortest.size());
           for(int i=0;i<shortest.size();i++){
               System.out.print(shortest.get(i)+" ");
           }
            System.out.println();
        }




    }
}
