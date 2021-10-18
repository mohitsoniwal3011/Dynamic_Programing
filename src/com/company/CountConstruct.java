package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
PROBLEM STATEMENT ::

Write a function 'countConstruct(target,wordBank) that accepts a string 'target' and an array of strings  'wordBank' as arguments
the function should return a number indicating the number of ways to construct the string 'target' by concatenating the strings from
the given set of strings. you may reuse the elements of the array 'wordBank' as many times as needed
 */

public class CountConstruct {
    public int countConstruct(String target, String [] wordBank, HashMap<String ,Integer> memo){
        if(memo.containsKey(target)){
            return memo.get(target);
        }
        if(target.equals("")){
            return 1;
        }
        int ways =0;
        for(int i=0;i<wordBank.length;i++){
            if(target.indexOf(wordBank[i]) == 0){
                ways += countConstruct(target.substring(wordBank[i].length()),wordBank,memo);
            }
        }
        memo.put(target,ways);
        return ways;
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
        HashMap<String,Integer> memo=new HashMap<>();
        CountConstruct c=new CountConstruct();
        System.out.println(c.countConstruct(target,wordBank,memo));
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
