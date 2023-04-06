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

    public BoundedPriorityQueueSet() {
        super();
        max = MAX;
    }

    public BoundedPriorityQueueSet(int max) {  
        this.max = max;
    }

    @Override
    public boolean add(Task value) {

        Node newNode = new Node(value);

        if (isEmpty()) {

            first = newNode;
            last = newNode;
        } else if (value.compareTo(first.data) < 0) {
            newNode.next = first;
            first = newNode;

        } else {
            Node current = first.next;
            Node prev = first;
            while (current != null && value.compareTo(current.data) > 0) {
                prev = current;
                current = current.next;
            }

            prev.next = newNode;
            newNode.next = current;

            if (current == null) {
                last = newNode;
            }
        }
        return true;
    }
    public boolean isFull(){
        return size >= max;
      
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
    public boolean add(Task value, int pos) {
        throw new UnsupportedOperationException("Method not available for queues");
    }
    
    @Override
    public Task remove(int num){
         throw new UnsupportedOperationException("Method not available for queues"); 
    }
}
