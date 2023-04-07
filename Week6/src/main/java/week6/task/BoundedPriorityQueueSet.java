/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week6.task;

import java.util.NoSuchElementException;

/**
 *
 * @author aoife
 */
public class BoundedPriorityQueueSet extends LinkedList {
private static final int MAX = 10;
     private final int max;
     
      public BoundedPriorityQueueSet(){
          super();
          max = MAX;
    }
      public BoundedPriorityQueueSet(int maxCap) {
           super();
          this.max = maxCap;
        
    }
  public boolean isFull(){
        return size >= max;
    }   
  

    @Override
    public int add(Task value) throws DuplicateElementException {

        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
         Node newNode = new Node(value);
         Node current = first;
         Node prev = null;
         int pos =0;
           
       while (current != null && value.compareTo(current.data) < 0) {
           prev = current;
           current = current.next;
           pos++;
        } 
       if(current != null && value.equals(current.data)){
       throw new DuplicateElementException("Task is alrady in the queue");
       }
       if (prev == null) {
                first = newNode;
            }
       else{
           prev.next = newNode;
        }
       newNode.next=current;
        size++;
        int index = indexOf(value);
       return index;
    }

    public Task peek(){
        if(size == 0){
            return null;
        }
        else{
            return first.data;
        }
    }
    public Task remove(){
        if(isEmpty()){
            throw new NoSuchElementException("The queue is empty");
        }
        return super.remove(0);
    }
     @Override
    public int add(Task value, int pos) {
        throw new UnsupportedOperationException("Method not available for queues");
    }
    
    @Override
    public Task remove(int num){
         throw new UnsupportedOperationException("Method not available for queues"); 
    }
}
