/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab3;

/**
 *
 * @author riyad
 */

public class DigitCounter extends AbstractCounter {
    
    // Constructor for creating a DigitCounter object
    DigitCounter() {
        super(); // Call the constructor of the superclass (AbstractCounter)
    }
    
    /**
     * Increment the value of the digit counter by 1.
     * If the value is less than 9, it adds 1 to the value.
     * If the value is 9, it resets the value to 0.
     */
    public void increment() {
        if (value < 9) {
            value = value + 1;
        } else {
            value = 0;
        }
    }
    
    /**
     * Decrement the value of the digit counter by 1.
     * If the value is greater than 0, it subtracts 1 from the value.
     * If the value is 0, it sets the value to 9 (cyclic decrement).
     */
    public void decrement() {
        if (value > 0) {
            value = value - 1;
        } else {
            value = 9;
        }
    }
}
