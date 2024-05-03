/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab4;

/**
 *
 * @author riyad
 */
import java.util.ArrayList;

public class Queue<Integer> {
    // Overview: Following the FIFO (First-In, First-Out) approach, Queue is a mutable
    // set of elements that adds an initial element and then removes the initial element.
    //
    // The abstraction function is:
    // AF(c) = {c.queue[i].toString | 0 <= i < c.queue.size()}
    //
    //for each element "i" in the list for queue, get the element "i" such that "i" is 
    //in between 0 and the queue's size/length
    
    // The rep invariant:
    // c.queue != null
    //    
    // informally: lists in queue cannot be null, or else will return false
    // 
    
    // the rep/instance variable declared
    // the Queue<Integer> class encapsulates this private instance variable
    // which means this class has full access to it only
    private ArrayList<Integer> queue;

    // constructor
    public Queue() {
        // EFFECTS: Creates a new Queue object as an array list
        queue = new ArrayList<>();
    }
    
    // methods for Queue Abstract Data Type (ADT) listed below
    //  methods used as interface so that users interact with queue 
    // they also encapsulate the implementation details of how the queue works internally
    public void enqueue(Integer element) {
        // MODIFIES: element
        // EFFECTS: appends/adds an element to the rear end of the queue (first in)
        queue.add(element);
    }
    
    public Integer dequeue(){
        //MODIFIES: this // alters the state of the current object by removing an element from the queue.
        // EFFECTS: removes an element from the front end of the queue, the first one
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty!");
        }
        return queue.remove(0);
    }
    
    
    public boolean isEmpty() {
        // EFFECTS: checks and returns true if the queue is empty;
        if (queue.isEmpty()) { 
            return true; }
        return false;
    }
    
    public boolean repOK() {
        // EFFECTS: returns true if the rep invariant holds for this, otherwise return false
        if (queue == null) {
            return false; }
        return true;
    }
    
    public String toString() {
        // EFFECTS: returns a string that contains the elements in
        // queue; implements the abstraction function.
        return queue.toString();
    }
}