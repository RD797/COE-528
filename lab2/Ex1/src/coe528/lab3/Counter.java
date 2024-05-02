/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package coe528.lab3;

/**
 *
 * @author riyad
 */
/**
 * The Counter interface defines the contract for objects that represent a counter.
 * It specifies the methods that must be implemented by classes that implement this interface.
 */
public interface Counter {
    
    String count();
    void increment();
    void decrement();
    void reset();
    
}
