/*Given a string S, how many distinct sub-strings of S are palindromes?

        
	    
	    static int palindrome(String s) {
	       int matrix[]

	    }

	    =======

		Sample Input 

		s=aabaa

		Sample output 
		  
		 5

		Explanation
		
		
		 b a b 
       b T F T 
       a   T F
       b     T
       
		Sample Case 1: a, aa, aabaa, aba, b*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        System.out.println(palindrome("aabaa"));
    }
    
    
    public static int palindrome(String str){
        if(str == null || str.length() ==0 ){
            return 0;
        }
        int n = str.length();
        int palindromes =0;
        boolean matrix[][] = new boolean[n][n];
        Set<String> palindromeList = new HashSet();
        
        for(int i =0 ; i<n; i++){
            
            matrix[i][i] =true;
            palindromes++;
            System.out.println(str.charAt(i));

            palindromeList.add(String.valueOf(str.charAt(i)));
        }
        //aba
        //aba
        for(int i = 0; i<n-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                matrix[i][i+1] = true;
                System.out.println(String.valueOf(str.substring(i,i+2)));

                palindromeList.add(String.valueOf(str.substring(i,i+2)));

                 palindromes++;
            }
        }
        
        for(int  k = 3; k<=n; k++){
            for(int i =0 ; i< n-k+1; i++){
                int j = i+k-1;

                if(str.charAt(i) == str.charAt(j) && matrix[i+1][j-1]){
                                System.out.println("####"+String.valueOf(str.substring(i,j+1)));

                    matrix[i][j] = true;
                    palindromeList.add(String.valueOf(str.substring(i,j)));
                    palindromes++;
            
                }
            }
        }
        
    return  palindromeList.size();   
    }
    
}