/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.boundedpriorityqueueset;

/**
 *
 * @author user
 */
public class BoundedPriorityQueueSet {

    private static final int INITIAL_CAPACITY = 10;
    private int capacity;
    private int count;
    private Node first;
    private Node last;

    public BoundedPriorityQueueSet() {
        first = null;
        last = null;
        count = 0;
        capacity = INITIAL_CAPACITY;
    }

    public BoundedPriorityQueueSet(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("invalid capacity");
        }
        first = null;
        last = null;
        count = 0;
        this.capacity = capacity;
    }

    public int size() {
        return count;
    }
    
    public boolean isEmpty(){
        return count==0;
    }
    
    public boolean isFull(){
        return count==capacity;
    }
    
    public int add(){
        
    }
            
            
    private class Node {

        private Task data;
        private Node next;

        private Node(Task data) {
            this.data = data;
            next = null;
        }
    }

}
