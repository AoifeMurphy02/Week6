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
/**
 * Bounded priority queue class that extends the LinkedList class has a maximun
 * capacity
 */
public class BoundedPriorityQueueSet extends LinkedList {

    private static final int MAX = 10;
    private final int max;

    /**
     * constructs a BoundedPriorityQueueSet with a maximun of 10
     */
    public BoundedPriorityQueueSet() {
        super();
        max = MAX;
    }

    /**
     * constructs a BoundedPriorityQueueSet with a maximun capacity passed to it 
     * @param maxCap the maximun capacity
     */
    public BoundedPriorityQueueSet(int maxCap) {
        super();
        this.max = maxCap;

    }
    /**
     * see if the queue is full
     * @return true if its full or false if its not 
     */
    public boolean isFull() {
        return size >= max;
    }
    /**
     * Adds a task to the queue in order of the Task's priority
     * @param value the Task to be added to the queue
     * @return the position the Task was added at 
     * @throws DuplicateElementException if the Task is in the queue already
     * @throws IllegalStateException if the queue is full
     */
    @Override
    public int add(Task value) throws DuplicateElementException {

        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        Node newNode = new Node(value);
        Node current = first;
        Node prev = null;
        int pos = 0;

        while (current != null && value.compareTo(current.data) < 0) {
            prev = current;
            current = current.next;
            pos++;
        }
        if (current != null && value.equals(current.data)) {
            throw new DuplicateElementException("Task is already in the queue");
        }
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        newNode.next = current;
        size++;

        return pos;
    }
    /**
     * To show the firs element in the queue 
     * @return the first task in the quere 
     */
    public Task peek() {
        if (size == 0) {
            return null;
        } else {

            return first.data;
        }
    }
    /**
     * Revomed and returns the element at the front of the queue
     * @return the elemnt at the front of this queue
     * @throws NoSuchElementException if this queue is empty.
     */
    
    public Task remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }
        return super.remove(0);
    }

    @Override
    public int add(Task value, int pos) {
        throw new UnsupportedOperationException("Method not available for queues");
    }

    @Override
    public Task remove(int num) {
        throw new UnsupportedOperationException("Method not available for queues");
    }
}
