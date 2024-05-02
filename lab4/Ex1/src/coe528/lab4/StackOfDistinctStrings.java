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
public class StackOfDistinctStrings {
// Overview: StacksOfDistinctStrings are mutable, bounded
// collection of distinct strings that operate in
// LIFO (Last-In-First-Out) order.
//
// The abstraction function is:
// a) Write the abstraction function here
// The abstraction function is:
// 
    //
    //   The abstraction function is
    //       AF(c) = (c.items[i].toString | 0 <= i <c.items.size()}
    //for each element "i" in the list for items, get the element "i" such that "i" is 
    //in between 0 and the item's size/length
    //       
    //
    //   The rep invariant is:
    //       c.items != null &&
    //       for all integers i, j . (0 <= i < j < c.items.size =>
    //          c.items[i].toString != c.items[j].toString)
    //
// informally: list of items cannot be null, each element must be distinct from each other
//
//
//
//the rep
private ArrayList<String> items;
// constructor
public StackOfDistinctStrings() {
// EFFECTS: Creates a new StackOfDistinctStrings object
    items = new ArrayList<String>();
}
public void push(String element) throws Exception {
// MODIFIES: this
// EFFECTS: Appends the element at the top of the stack
// if the element is not in the stack, otherwise
// does nothing.
    if(element == null) throw new Exception();
    if(false == items.contains(element))
        items.add(element);
}
public String pop() throws Exception {
// MODIFIES: this // alters the state of the current object by removing an element from the stack.
// EFFECTS: Removes an element from the top of the stack
if (items.isEmpty()) throw new Exception();
return items.remove(items.size()-1);
}

public boolean repOK() {
// EFFECTS: Returns true if the rep invariant holds for this
// object; otherwise returns false
// c) Write the code for the repOK() here
// Check if items is not null
    if (items == null) {
        return false;
    }

    // Check if all elements are distinct
    for (int i = 0; i < items.size(); i++) {
        for (int j = i + 1; j < items.size(); j++) {
            if (items.get(i).equals(items.get(j))) {
                return false;
            }
        }
    }

    // Rep invariant holds
    return true;
}


public String toString() {
// EFFECTS: Returns a string that contains the strings in the
// stack and the top element. Implements the
// abstraction function.
// d) Write the code for the toString() here
        // Initialize an empty string to store the concatenated elements of the stack
String results = "";

// Iterate over each string element in the items list (foreach loop)
for (String string : items) {
    // add each string element to result
    results += string;
}

// Return the concatenated string representation of the stack
return results;

        
}
}
