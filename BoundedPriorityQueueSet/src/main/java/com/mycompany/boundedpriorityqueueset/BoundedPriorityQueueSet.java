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

    public int size() {
        return count;
    }
    
    public boolean isEmpty(){
        return count==0;
    }
    
    public boolean isFull(){
        return count==capacity;
    }
    
    public boolean checkDuplicate(Task t){
        if(isEmpty()==false){
        Node current=first;
            for(int i=0; i<size(); i++){
                if(current.data.equals(t)){
                    return true;
                }
                current=current.next;
            }
        }
            return false;
    }
    
    public int add(Task task){
        Node newNode=new Node(task);
        int pos=0;
         if(isEmpty()==true){
             first=newNode;
             count++;
         }
         
         else if(checkDuplicate(task)==true){
             throw new DuplicateElementException("Already in queue");
         }
         
         else{
             if(count==capacity){
                 throw new IllegalStateException("Queue is full");
             }
          
             else {
        if(first.data.getDeadline().compareTo(task.getDeadline())>=0){
            newNode.next=first;
            first=newNode;
            count++;
            return 0;
        }
       /* else if(first.data.getDeadline().compareTo(task.getDeadline())==0){
           newNode.next=first.next;
           first.next=newNode;
        }*/

        else if(last.data.getDeadline().compareTo(task.getDeadline())<=0){
            last.next=newNode;
            last=newNode;
            pos=count+1;
            count++;
            return pos;
        }
        else {
            Node current=first;
            Node prev=first;
            for(int i=0; i<size(); i++){
                
                if(current.data.getDeadline().compareTo(task.getDeadline())>=0){
                    newNode.next=current;
                    prev.next=newNode;
                    pos=i-1;
                    return pos;
                }
                prev=current;
                current=current.next;
            }
        }
         }
         }
        
        return pos;
    }
           
     public Task peek(){
       if(isEmpty()==true){
           throw new NoSuchElementException("Queue is empty");
         }
      return first.data;
    }
     
     public Task remove(){
       if(isEmpty()==true){
           throw new NoSuchElementException("Queue is empty");
         }
       Task t=first.data;
       first=first.next;
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
