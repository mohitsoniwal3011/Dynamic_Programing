package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
/*
PROBLEM STATEMENT ::

Write a function 'canConstruct(target,wordBank) that accepts a string 'target' and an array of 'strings' as arguments

the function should return a boolean indicating whether the 'target' can be constructed by concatenating the strings from
the given set of strings or not. you may reuse the elements of the array 'wordBank' as many times as needed

 */
public class CanConstruct {

    public boolean canConstruct(String target, String [] wordBank, HashMap<String,Boolean> memo){
        if(memo.containsKey(target)){
            return memo.get(target);
        }
        if(target.equals("")){
            return true;
        }
        int index;
        for(int i=0;i< wordBank.length;i++){
            index=target.indexOf(wordBank[i]);
            //System.out.println("Index of "+wordBank[i] +" = "+index+" in target ="+target);
            if(index == 0){

                if((canConstruct(target.substring(wordBank[i].length()),wordBank,memo))){
                    memo.put(target,true);
                    return true;
                }
            }
        }
        memo.put(target,false);
        return false;
    }

    public static void main(String[] args) throws IOException {
        String target, sub ;
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
        HashMap<String,Boolean> memo=new HashMap<>();
        CanConstruct c=new CanConstruct();
        System.out.println(c.canConstruct(target,wordBank,memo));
    }
}

//Complexity
//Brute force
// if m=target.length()
// and  n =wordBank.length
// time - O((n^m)*(m*n + m ))  // O(m*n)  is the complexity for str.indexOf() operation and 'm' is the complexity of str.subString() method
//because maximum length of substring can be 'm'
//space =O(m^2)

///Memoized
// if m=target.length()
// and  n =wordBank.length
// time - O((m*n)*(m*n + m ))  // O(m*n)  is the complexity for str.indexOf() operation and 'm' is the complexity of str.subString() method
// ==> time - O(m^2(n^2 +n ))  ==> O((M^2)*(n^2))
//because maximum length of substring can be 'm'
//space =O(m^2)

//
