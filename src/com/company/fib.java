package com.company;

import java.util.HashMap;
import java.util.Scanner;

//Write a programme  to calculate the Nth number of a fibonacci sequence
public class fib {
    public Long fibonacci(Long n, HashMap<Long,Long> memo){
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        if(n == 0 || n == 1){
            return n;
        }
        else {
            memo.put(n,fibonacci(n-1,memo)+fibonacci(n-2,memo));
            return memo.get(n);
        }
    }

    public static void main(String[] args) {
        Long n ;
        System.out.println("Enter the number n: ");
        n =new Scanner(System.in).nextLong();
        HashMap<Long,Long> memo =new HashMap<>();
        Long res=new fib().fibonacci(n,memo);
        System.out.println("The fibonacci of the number is : ");
        System.out.println(res);

        System.out.println(Long.MAX_VALUE);
    }
}
