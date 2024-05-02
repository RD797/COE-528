/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab2;

import java.util.Arrays;

//Requires:  Non-null character strings a and b 
//Modifies: None, new arrays are created to manipulate and sort
//Effects: Method will take input strings and clear all spaces and uppercases. It will then change them into a list of char to be murated and sorted
// Once sorted the two arrays will be compared and if they are identical they will be anagrams

/**
 *
 * @author riyad
 */
public class AnagramChecker {
    
    public static boolean areAnagrams(String a, String b){
    
        // Remove spaces from both strings for accurate comparison.
        String cleanA = a.replaceAll(" ", "");
        String cleanB = b.replaceAll(" ", "");
        
        // If the cleaned strings have different lengths, they cannot be anagrams.
        if (cleanA.length() != cleanB.length()){
            return false;
        } else{
            // Convert the cleaned strings to char arrays and sort them.
            char A[] =cleanA.toLowerCase().toCharArray();
            char B[] = cleanB.toLowerCase().toCharArray();
            
            Arrays.sort(A);
            Arrays.sort(B);
            // Check if the sorted char arrays are equal, indicating that the strings are anagrams.
            return Arrays.equals(A, B);
            
     
        }
    
    
    }
    
    
    public static void main(String[] args) {
        if(args.length == 2) {
            System.out.println(areAnagrams(args[0],args[1]));
        }
    }
}
    

