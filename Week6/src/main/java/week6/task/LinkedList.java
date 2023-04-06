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

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
        // return size == 0;
    }

    public int size() {
        return size;
    }

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

    public boolean add(Task value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
        return true;
    }

    public boolean add(Task value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid position provided");
        }

        if (index == 0) {
            addFirst(value);
        }
        else{

        Node current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
        size++;
        
    }
        return true;
    }

    public int indexOf(Task value) {
        if (first == null) {
            return -1;
        }

        Node current = first;
        for (int i = 0; i < size; i++) {
            if (value.equals( current.data)){
                return i;
            }
            current = current.next;
        }
        return -1;
    }

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
            
            if(current.next == last){
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

