package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class AllConstruct {
    public ArrayList<ArrayList<String >> allConstructs(String target, String [] wordBank,HashMap<String ,ArrayList<ArrayList<String >>> memo){
        if(memo.containsKey(target)){
            return memo.get(target);
        }
        if(target.equals("")){
            ArrayList<ArrayList<String>>  retValue=new ArrayList<>();
            retValue.add(new ArrayList<>());
            return retValue;
        }
        ArrayList<ArrayList<String>>  solutions=new ArrayList<>();
        ArrayList<ArrayList<String>> totalWays;
        for(int i=0;i<wordBank.length;i++){
            if(target.indexOf(wordBank[i]) == 0){
                ArrayList<ArrayList<String >> result=allConstructs(target.substring(wordBank[i].length()),wordBank,memo);
                if(result != null){
                    totalWays=new ArrayList<>();
                    for(int k=0;k<result.size();k++){
                        //If we do not clone it then it will affect the solution set of target.substring(wordBank[i].length);
                        //(make a deep copy of result object and then add it to solution for target string)
                        ArrayList<String> t= (ArrayList<String>) result.get(k).clone();
                        t.add(0,wordBank[i]);
                        totalWays.add(t);
                    }
                    solutions.addAll(totalWays);
                }
            }
        }
        memo.put(target,solutions);
        return solutions;
    }

    public static void main(String[] args) throws IOException {
        String target ;
        int n;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of string elements: ");
        n=Integer.parseInt(br.readLine());
        System.out.println("Enter the Array of String :");
        String [] wordBank=new String[n];
        for(int i=0;i<n;i++){
            wordBank[i]=br.readLine();
        }
        System.out.println("Enter the target  String: ");
        target=br.readLine();
        HashMap<String,ArrayList<ArrayList<String>>> memo=new HashMap<>();
        AllConstruct c=new AllConstruct();
        ArrayList<ArrayList<String>> sol=c.allConstructs(target,wordBank,memo);
        ArrayList<String > t;
        System.out.println("Total Ways = "+sol.size());
        System.out.println(sol);
    }
}


//Time Complexity For Memoized Function
//m =target.length()
//n = wordBank.length()
//In worst case there can be maximum of n^m  combinations so complexity after memoization is:
//time - O(n^m)
//space = O(m)  //size of the output is not considered here

