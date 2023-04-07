/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package week6.task;

import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
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
     * Test of add method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testAdd_TaskEmptyList() {
        System.out.println("add one Task to empty list");

        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        assertTrue(instance.add(new Task("a", "b", LocalDate.parse("2024-02-01"))));
        assertEquals(1, instance.size());

    }

    /**
     * Test of isFull method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testIsFull0Task() {
        System.out.println("Test for is isFull with 0 Task");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();

        boolean expResult = false;
        boolean result = instance.isFull();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsFullOneTask() {
        System.out.println("Test for is isFull with one Task");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        instance.add(new Task("a", "a", LocalDate.parse("2024-02-01")));
        boolean expResult = false;
        boolean result = instance.isFull();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsFullTenTasks() {
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

    @Test
    public void testIsFull11Tasks() {
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
        instance.add(new Task("k", "k", LocalDate.parse("2024-02-11")));

        boolean expResult = true;
        boolean result = instance.isFull();
        assertEquals(expResult, result);
    }

    /**
     * Test of peek method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        Task expResult = null;
        Task result = instance.peek();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testRemove_0args() {
        System.out.println("remove");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        Task expResult = null;
        Task result = instance.remove();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testAdd_Task_int() {
        System.out.println("add");
        Task value = null;
        int pos = 0;
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        boolean expResult = false;
        boolean result = instance.add(value, pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testRemove_int() {
        System.out.println("remove");
        int num = 0;
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        Task expResult = null;
        Task result = instance.remove(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}