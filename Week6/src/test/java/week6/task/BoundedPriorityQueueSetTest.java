/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package week6.task;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aoife
 */
public class BoundedPriorityQueueSetTest {

    public BoundedPriorityQueueSetTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of add method with an empty queue
     */
    @Test
    public void testAdd_TaskEmptyQueue() throws IllegalStateException, DuplicateElementException {
        System.out.println("add one Task to empty queue");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        Task t1 = new Task("a", "a", LocalDate.parse("2024-02-01"));
        int pos = instance.add(t1);

        assertEquals(0, pos);
        assertEquals(1, instance.size);
        assertEquals(t1, instance.peek());

    }

    /**
     * Test of add method with an adding to the start
     */
    @Test
    public void testAddTask_start() throws DuplicateElementException {
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        Task t1 = new Task("b", "b", LocalDate.parse("2024-02-01"));
        Task t2 = new Task("a", "a", LocalDate.parse("2024-02-01"));
        int pos = instance.add(t2);
        int pos2 = instance.add(t1);
        Assertions.assertEquals(0, pos2);
        Assertions.assertEquals(2, instance.size());
        assertEquals(t1, instance.peek());
    }

    /**
     * Test of add method with adding to the middle of the queue
     */
    @Test
    public void testAdd_toMiddle() throws DuplicateElementException {
        System.out.println("add one Task to middle");

        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        Task t1 = new Task("a", "a", LocalDate.parse("2024-02-01"));
        Task t2 = new Task("c", "c", LocalDate.parse("2024-02-01"));
        Task t3 = new Task("b", "b", LocalDate.parse("2024-02-01"));
        instance.add(t1);
        instance.add(t2);
        int pos = instance.add(t3);
        assertEquals(1, pos);
        assertEquals(3, instance.size());
        assertEquals(t1, instance.get(2));
        assertEquals(t3, instance.get(1));
        assertEquals(t2, instance.get(0));
    }

    /**
     * Test of add method with adding to the end of the queue
     */
    @Test
    public void testAdd_toEnd() throws DuplicateElementException {
        System.out.println("add one Task to the end");

        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        Task t1 = new Task("a", "a", LocalDate.parse("2024-02-01"));
        Task t2 = new Task("c", "c", LocalDate.parse("2024-02-01"));
        Task t3 = new Task("b", "b", LocalDate.parse("2024-02-01"));
        instance.add(t1);
        instance.add(t3);
        instance.add(t2);

        assertEquals(3, instance.size());
        assertEquals(t3, instance.get(1));
        assertEquals(t1, instance.get(2));
        assertEquals(t2, instance.get(0));
    }

    /**
     * Test of add method with adding two of the same task to the queue
     */
    @Test
    public void testAddTwooftheSame() throws DuplicateElementException {
        System.out.println("add two of the same Task");

        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        Task t1 = new Task("a", "a", LocalDate.parse("2024-02-01"));
        Task t2 = new Task("a", "a", LocalDate.parse("2024-02-01"));

        instance.add(t1);

        try {
            instance.add(t2);
            instance.add(t1);
            fail("DuplicateElementException to be thrown");
        } catch (DuplicateElementException ex) {
            assertEquals("Task is already in the queue", ex.getMessage());
        }
        assertEquals(1, instance.size());
    }

    /**
     * Test of isFull method with 0 Tasks
     */
    @Test
    public void testIsFull0Task() {
        System.out.println("Test for is isFull with 0 Task");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();

        boolean expResult = false;
        boolean result = instance.isFull();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFull method with 1 Task
     */
    @Test
    public void testIsFullOneTask() {
        System.out.println("Test for is isFull with one Task");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        //  instance.add(new Task("a", "a", LocalDate.parse("2024-02-01")));
        boolean expResult = false;
        boolean result = instance.isFull();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFull method with 10 Tasks
     */
    @Test
    public void testIsFullTenTasks() throws DuplicateElementException {
        System.out.println("Test for is isFull with ten Tasks");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        instance.add(new Task("a", "a", LocalDate.parse("2024-02-01")));
        instance.add(new Task("b", "b", LocalDate.parse("2024-02-02")));
        instance.add(new Task("c", "c", LocalDate.parse("2024-02-03")));
        instance.add(new Task("d", "d", LocalDate.parse("2024-02-04")));
        instance.add(new Task("e", "e", LocalDate.parse("2024-02-05")));
        instance.add(new Task("f", "f", LocalDate.parse("2024-02-06")));
        instance.add(new Task("g", "g", LocalDate.parse("2024-02-07")));
        instance.add(new Task("h", "h", LocalDate.parse("2024-02-08")));
        instance.add(new Task("i", "i", LocalDate.parse("2024-02-09")));
        instance.add(new Task("j", "j", LocalDate.parse("2024-02-10")));

        boolean expResult = true;
        boolean result = instance.isFull();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFull method with 11 Tasks
     */
    @Test
    public void testIsFull11Tasks() throws DuplicateElementException {
        System.out.println("Test for is isFull with 11 Tasks");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        instance.add(new Task("a", "a", LocalDate.parse("2024-02-01")));
        instance.add(new Task("b", "b", LocalDate.parse("2024-02-02")));
        instance.add(new Task("c", "c", LocalDate.parse("2024-02-03")));
        instance.add(new Task("d", "d", LocalDate.parse("2024-02-04")));
        instance.add(new Task("e", "e", LocalDate.parse("2024-02-05")));
        instance.add(new Task("f", "f", LocalDate.parse("2024-02-06")));
        instance.add(new Task("g", "g", LocalDate.parse("2024-02-07")));
        instance.add(new Task("h", "h", LocalDate.parse("2024-02-08")));
        instance.add(new Task("i", "i", LocalDate.parse("2024-02-09")));
        instance.add(new Task("j", "j", LocalDate.parse("2024-02-10")));

        assertThrows(IllegalStateException.class, () -> {
            instance.add(new Task("k", "k", LocalDate.parse("2024-02-12")));
        });

    }

    /**
     * Test of peek method with a empty queue.
     */
    @Test
    public void testPeekEmpty() {
        System.out.println("peek empty queue");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        assertNull(instance.peek());

    }

    /**
     * Test of peek method with a 2 tasks in the queue.
     */
    @Test
    public void testPeekTwoTasks() throws DuplicateElementException {
        System.out.println("peek two tasks");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        Task task1 = new Task("Task 1", "1", LocalDate.parse("2024-02-01"));
        Task task2 = new Task("Task 2", "2", LocalDate.parse("2024-02-10"));
        instance.add(task1);
        instance.add(task2);
        assertEquals(task2, instance.peek());
    }

    /**
     * Test of remove from an empty queue .
     */
    @Test
    public void testRemoveEmptyQueue() throws DuplicateElementException {
        System.out.println("remove from empty queue");

        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        try {
            instance.remove();
            fail("NoSuchElementException to be thrown");
        } catch (NoSuchElementException ex) {
            assertEquals("The queue is empty", ex.getMessage());
        }
    }

    /**
     * Test of remove from the first place in the queue .
     */
    @Test
    public void testRemoveFirst() throws DuplicateElementException {
        System.out.println("remove first");

        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        Task t1 = new Task("a", "a", LocalDate.parse("2024-02-01"));
        Task t2 = new Task("b", "b", LocalDate.parse("2024-02-01"));
        Task t3 = new Task("c", "c", LocalDate.parse("2024-02-01"));
        instance.add(t1);
        instance.add(t2);
        instance.add(t3);

        Task result = instance.remove();
        assertEquals(2, instance.size);
        assertEquals(t3, result);
        assertEquals(t1, instance.get(1));
        assertEquals(t2, instance.get(0));
    }

    /**
     * Test of remove with only 1 task in the queue.
     */
    @Test
    public void testRemoveOnly1Task() throws DuplicateElementException {
        System.out.println("remove Only 1 Task");

        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        Task t1 = new Task("a", "a", LocalDate.parse("2024-02-01"));

        instance.add(t1);

        Task result = instance.remove();
        assertEquals(0, instance.size);

        assertEquals(t1, result);
        assertTrue(instance.isEmpty());

    }
}
