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
        max = MAX;
        this.max = max;
    }
}
