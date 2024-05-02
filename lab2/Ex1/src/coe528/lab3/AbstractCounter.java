/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab3;

/**
 *
 * @author riyad
 */

public abstract class AbstractCounter implements Counter {
    
    // The value of the counter
    protected int value;
     
    
     // Reset the value of the counter to 0.
     
    @Override
    public void reset() {
        value = 0;
    }
   
    
     // Return the current value of the counter as a string.
     
    @Override
    public String count() {
        return String.valueOf(value);
    }
    
    /**
     * Query and return the current value of the counter as a string.
     * @return The current value of the counter.
     */
    // used internally within the class hierarchy to access the counter value without directly 
    //exposing the count() method 
    //public String querycount() {
      //  return count();
    //}
}
