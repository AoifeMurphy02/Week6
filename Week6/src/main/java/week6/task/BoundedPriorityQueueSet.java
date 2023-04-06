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
    @Override
 public boolean add(Task value) {

        Node newNode = new Node(value);

        if (isEmpty()) {

            first = newNode;
            last = newNode;
        }
 
        else if(value.compareTo( first.data) <0){
         newNode.next = first;
          first = newNode;
         
        }
         else{
           Node current = first.next;
            Node prev = first;
            while(current != null && value.compareTo(current.data)>0){
                prev = current;
                current = current.next;
        }
         
        
            prev.next = newNode;
            newNode.next = current;
        
        if(current == null){
          last = newNode;  
        }
        }
        return true;
    }



    
    public BoundedPriorityQueueSet(int max) {
        max = MAX;
        this.max = max;
    }
}
