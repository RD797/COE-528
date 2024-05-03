/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab3;

/**
 *
 * @author riyad
 */

public class LinkedDigitCounter extends AbstractCounter {
    
    // Reference to the digit counter to the left of this one
    private Counter leftNeighbour = null;
   
    LinkedDigitCounter(Counter leftNeighbour) {
        super(); // Call to parent class constructor
        this.leftNeighbour = leftNeighbour;
    }
    
    //Increment the value of the digit by 1.
     // If the value reaches 9, it resets to 0 and increments the left neighbor.
     
    @Override
    public void increment() {
        if(value < 9) {
            value = value + 1;
        } else {
            value = 0;
            // Increment the digit to the left
            leftNeighbour.increment();
        }
    }
    
    
     // Decrement the value of the digit by 1.
      //If the value is 0, it resets to 9 and decrements the left neighbor.
     
    @Override
    public void decrement() {
        if(value > 0) {
            value = value - 1;
        } else {
            value = 9;
            // Decrement the digit to the left
            leftNeighbour.decrement();
        }
    }
}
