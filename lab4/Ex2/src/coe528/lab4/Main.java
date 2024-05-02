/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coe528.lab4;

/**
 *
 * @author riyad
 */
public class Main {
    public static void main(String[] args) {
// Test the queue implementation
    Queue<Integer> queue = new Queue<>();
    // Enqueue elements
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);

// Dequeue elements
    int dequeuedElement1 = queue.dequeue(); // 10
    int dequeuedElement2 = queue.dequeue(); // 20
// Check if the queue is empty
    boolean isEmpty = queue.isEmpty(); // false

    // Expected output
    System.out.println("Dequeued element 1: " + dequeuedElement1);
    System.out.println("Dequeued element 2: " + dequeuedElement2);
    System.out.println("Is the queue empty? " + isEmpty);
    }
}

