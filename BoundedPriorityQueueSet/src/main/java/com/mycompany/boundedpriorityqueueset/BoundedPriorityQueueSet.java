/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.boundedpriorityqueueset;

import java.util.NoSuchElementException;

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
/**Gets the number of Task in Queue
 @return returns an int
 **/
    public int size() {
        return count;
    }
/**checks if the queue is empty
 @return returns a Boolean indicating if queue is empty 
 **/
    public boolean isEmpty() {
        return count == 0;
    }
/**checks if the queue has reached it's maximum capacity
 @return returns a Boolean indicating if queue is full 
 **/
    public boolean isFull() {
        return count == capacity;
    }
/**checks if there is a duplicate task in queue 
 @param t, takes in a Task to check queue
 * @return returns a Boolean if duplicate was found
 **/
    public boolean checkDuplicate(Task t) {
        if (isEmpty() == false) {
            Node current = first;
            for (int i = 0; i < size(); i++) {
                if (current.data.equals(t)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }
/**Adds Task to the queue in ascending order
 * @param task, takes in a task to be added
 * @return returns an int, the position in which the task was inserted
 * @throws DuplicateElementException if the Task is already present in the queue
 * @throws IllegalStateException if the queue is already full
 **/
    public int add(Task task) {
        Node newNode = new Node(task);
        int pos = 0;
        if (isEmpty() == true) {
            first = newNode;
            last = newNode;
            count++;
        } else if (checkDuplicate(task) == true) {
            throw new DuplicateElementException("Already in queue");
        } else {
            if (count == capacity) {
                throw new IllegalStateException("Queue is full");
            } else {
                if (first.data.getDeadline().compareTo(task.getDeadline()) > 0) {
                    newNode.next = first;
                    first = newNode;
                    count++;
                    return 0;
                } /* else if(first.data.getDeadline().compareTo(task.getDeadline())==0){
           newNode.next=first.next;
           first.next=newNode;
        }*/ else if (last.data.getDeadline().compareTo(task.getDeadline()) < 0) {
                    last.next = newNode;
                    last = newNode;
                    pos = count + 1;
                    count++;
                    return pos;
                } else {
                    Node current = first;
                    Node prev = first;
                    for (int i = 0; i < size(); i++) {

                        if (current.data.getDeadline().compareTo(task.getDeadline()) > 0) {
                            newNode.next = current;
                            prev.next = newNode;
                            count++;
                            pos = i;
                            return pos;
                        } else if (current.data.getDeadline().compareTo(task.getDeadline()) == 0) {
                            newNode.next = current.next;
                            current.next = newNode;
                            count++;
                            pos = i + 1;
                            return pos;
                        }

                        prev = current;
                        current = current.next;
                    }
                }
            }
        }

        return pos;
    }
/**Gets the first Task in the queue
 @return returns the first Task in the queue
 * @throws NoSuchElementException if the queue is empty
 **/
    public Task peek() {
        if (isEmpty() == true) {
            throw new NoSuchElementException("Queue is empty");
        }
        return first.data;
    }
/**Removes the first Task in the queue
 @return the first Task
 * @throws NoSuchElementException if the queue is empty
 **/
    public Task remove() {
        if (isEmpty() == true) {
            throw new NoSuchElementException("Queue is empty");
        }
        Task t = first.data;
        first = first.next;
        return t;
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
