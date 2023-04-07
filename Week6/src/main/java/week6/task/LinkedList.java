/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week6.task;

/**
 *
 * @author aoife
 */
public class LinkedList {

    protected Node first;
    protected Node last;
    protected int size;

    /**
     * Constructs an empty list
     */
    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * removes all Nodes from the list
     */
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * To see if the list is empty
     *
     * @return true if its empty or false if its not
     */
    public boolean isEmpty() {
        return first == null;
        // return size == 0;
    }

    /**
     * gets the size of the list
     *
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * adds a new node containing a Task to the start of the list
     *
     * @param task the Task to be added
     * @return true if tasks was added
     */
    public boolean addFirst(Task task) {
        Node newNode = new Node(task);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        size++;
        return true;
    }

    /**
     * Gets the Task at with the index in the list.
     *
     * @param index the index of the the Task to be found
     * @return the Task at the index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index
     * >= size).
     */
    public Task get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid position provided");
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Add a new node with the Task at the end of the list 
     * @param value to be added to the list 
     * @return the index where the Task was added 
     * @throws DuplicateElementException if the Task is already in the list
     */
    public int add(Task value) throws DuplicateElementException {
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
        int index = indexOf(value);
        return index;
    }
    /**
     * Add a new node with a Task at a index
     * @param value the Task to be added 
     * @param index where the Task should be added
     * @return the index where the Task was added 
     * @throws  IndexOutOfBoundsException if the index is out of range.
     */
    public int add(Task value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid position provided");
        }

        if (index == 0) {
            addFirst(value);
        } else {

            Node current = first;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node newNode = new Node(value);
            newNode.next = current.next;
            current.next = newNode;
            size++;

        }
        return index;
    }
    /**
     * finds the index of the Task 
     * @param value the Task we are looking for
     * @return the index of the task we are looking for or -1 if its not in the list
     */
    public int indexOf(Task value) {
        if (first == null) {
            return -1;
        }

        Node current = first;
        for (int i = 0; i < size; i++) {
            if (value.equals(current.data)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }
    /**
     * Replaces the Task at the index in the list with a Task passed
     * @param index the index of the Task object to be replaced 
     * @param value the Task to be put in the index
     * @return the Task which was at the index previously
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public Task set(int index, Task value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid position provided");
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Task original = current.data;
        current.data = value;
        return original;
    }
    /**
     * Removed the Task at the index provided 
     * @param index the index of the task to de removed
     * @return the task that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range 
     */
    public Task remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Illegal position supplied!");
        }
        Task original;
        if (index == 0) {
            original = first.data;
            first = first.next;
        } else {
            Node current = first;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            if (current.next == last) {
                last = current;
            }
            original = current.next.data;
            current.next = current.next.next;
        }
        size--;
        return original;
    }

    protected static class Node {

        protected Task data;
        protected Node next;

        public Node(Task value) {
            this.data = value;
            this.next = null;
        }
    }
}
