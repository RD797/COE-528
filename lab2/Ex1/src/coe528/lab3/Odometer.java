/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab3;

/**
 *
 * @author riyad
 */

public class Odometer implements Counter {
    
    private int numOfDigits; // Number of digits in the odometer, entire thing
    private Counter digits[]; // Array of all digit counters, index counter 
    
    /**
     * Constructor to initialize the Odometer with the specified number of digits.
     * @param n The number of digits for the odometer.
     */
    Odometer(int n) {
        
        if (n <1)
            throw new IllegalArgumentException("Number of in odometer must be at least 1");
        try {
            this.numOfDigits = n;
            digits = new Counter[n]; // create object array to store digit counters
            digits[0] = new DigitCounter(); // Initialize the first digit counter, digitCounters starts at 0 for the first index
            // Initialize the rest of the digit counters as LinkedDigitCounters
            for (int i = 1; i < n; i++) {
                // Create linked array where objects point to their left neighbor
                digits[i] = new LinkedDigitCounter(digits[i - 1]);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect number of odometer digits"); // Handle invalid input
        }
    }
    
    /**
     * Output the current value of the counter as a string of digits.
     * @return The current value of the odometer as a string.
     */
    @Override
    public String count() {
        String output = ""; // Initialize output string
        boolean non_zero = false; // Flag to track if non-zero digit found
        // Iterate through each digit counter in the odometer
        for (int i = 0; i < numOfDigits; i++) {
            //combining all string of numbers together to create the reading
                output += digits[i].count(); // Append the digit count to output
            }
        
        return output; // Return the current value of the odometer as a string
    }
    
    /**
     * Increment the value of the right-most digit counter.
     */
    @Override
    public void increment() {
        digits[numOfDigits - 1].increment(); // Increment the right-most digit counter (last value digit)
    }
    
    
      //Decrement the value of the right-most digit counter.
     
    @Override
    public void decrement() {
        digits[numOfDigits - 1].decrement(); // Decrement the right-most digit counter(last value)
    }
    
    
     // Reset all digit counters in the odometer to 0.
     
    @Override
    public void reset() {
        for (int i = 0; i < numOfDigits; i++) {
            digits[i].reset(); // Reset all digit counters
        }
    }  
}
