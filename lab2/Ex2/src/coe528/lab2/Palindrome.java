/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab2;

/**
 *
 * @author riyad
 */

//Requires: non-null character input string 'a'
//Modifies: modifies no inputs, new arrays are created to manipulate and compare strings
//Effects:  Method clears up spaces in input string 'a' and converts upper to lowercase Returns true if the input string 'a' is a palindrome,
           //false otherwise. Palindrome is a sequence of characters that reads the same backward as forward, ignoring case and spaces.

public class Palindrome {
    
public static boolean isPalindrome(String a) {
    if (a==null || a.equals("")){
        return false;
    }
    
    // Convert the input string to lowercase and remove spaces to create a clean string.
    String cleanString = a.toLowerCase().replaceAll(" ", "");
    
    // Initialize an empty string to store reversed version of the clean string.
    String reverse = "";
    
    int length = cleanString.length();
    
     // Loop through the characters of the original string in reverse order,
    // building the reversed string.
    for (int i = a.length()-1; i>=0; i--){
        reverse += cleanString.charAt(i);
    }
    
    // Compare each character of the clean string with the corresponding character
    // in the reversed string. If any pair of characters doesn't match, it's not a palindrome.
    for (int i=0; i< length; i++){
        if (cleanString.charAt(i) != reverse.charAt(i)){
        return false;
        
        }
    
    }
    // If the loop completes without finding a mismatch, the string is a palindrome.
    return true;
}

public static void main(String[] args) {
    if(args.length == 1) {
        if (args[0].equals("1"))
            System.out.println(isPalindrome(null));
        else if (args[0].equals("2"))
            System.out.println(isPalindrome(""));
        else if (args[0].equals("3"))
            System.out.println(isPalindrome("deed"));
        else if (args[0].equals("4"))
            System.out.println(isPalindrome("abcd"));
}
}

}


    
  
    

    

