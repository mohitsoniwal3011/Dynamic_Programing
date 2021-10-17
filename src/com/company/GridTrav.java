package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GridTrav {
    public long gridTraveller3(int m,int n,HashMap<Long,Long> memo ){
        long key1 =m* 100L +n,key2=n* 100L +m;
        long x;
        if(memo.containsKey(key1) ){
            return memo.get(key1);
        }
        if(memo.containsKey(key2)){
            return memo.get(key2);
        }
        if(m == 0 || n == 0){
            return  0;
        }
        if(m==1 || n==1){
            return 1;
        }
        else {
            x =gridTraveller3(m-1,n,memo)+gridTraveller3(m,n-1,memo);
            memo.put(key1,x);
            memo.put(key2,x);
            return x;
        }
    }
    public static List<Integer> reverseArray(ArrayList<Integer> a) {
        // Write your code here
        int i,j,t;
        for(i=0,j=a.size()-1;i<= j ;i++,j--){
            t=a.get(i);
            a.add(i,a.get(j));
            a.add(j,t);
        }
        return a;
    }
    public static void main(String[] args) {
        int m,n;
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter dimensions of the grid:");
        m=sc.nextInt();
        n=sc.nextInt();
        HashMap<Long,Long> memo=new HashMap<>();
        GridTrav g =new GridTrav();
        long ways =g.gridTraveller3(m,n,memo);
        System.out.println("Number of Ways are "+ways);
    }
}
