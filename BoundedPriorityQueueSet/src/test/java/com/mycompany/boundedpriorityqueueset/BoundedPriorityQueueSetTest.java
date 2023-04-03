/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.boundedpriorityqueueset;

import java.time.LocalDate;
import java.time.Month;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author user
 */
public class BoundedPriorityQueueSetTest {

    /**
     * Test of size method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        LocalDate d = LocalDate.of(2023, Month.JUNE, 20);
        Task t1 = new Task("carl", "addition", d);
        instance.add(t1);
        int expResult = 1;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of isEmpty method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testIsEmpty_whenQueueIsEmpty() {
        System.out.println("isEmpty");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        LocalDate d = LocalDate.of(2023, Month.JUNE, 20);
        Task t1 = new Task("carl", "addition", d);
        instance.add(t1);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of isEmpty method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testIsEmpty_whenQueueIsNotEmpty() {
        System.out.println("isEmpty");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of isFull method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testIsFull_whenQueueIsNotFull() {
        System.out.println("isFull");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        LocalDate d = LocalDate.of(2023, Month.JUNE, 20);
        Task t1 = new Task("carl", "addition", d);
        instance.add(t1);
        boolean expResult = false;
        boolean result = instance.isFull();
        assertEquals(expResult, result);

    }

    /**
     * Test of isFull method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testIsFull_whenQueueIsFull() {
        System.out.println("isFull");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet(1);
        LocalDate d = LocalDate.of(2023, Month.JUNE, 20);
        Task t1 = new Task("carl", "addition", d);
        instance.add(t1);
        boolean expResult = true;
        boolean result = instance.isFull();
        assertEquals(expResult, result);

    }

    /**
     * Test of checkDuplicate method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testCheckDuplicate_whenThereIsNoDuplicate() {
        System.out.println("checkDuplicate");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        LocalDate d = LocalDate.of(2023, Month.JUNE, 20);
        Task t1 = new Task("carl", "addition", d);
        instance.add(t1);
        LocalDate d2 = LocalDate.of(2023, Month.JUNE, 21);
        Task t2 = new Task("cedric", "addition", d2);
        boolean expResult = false;
        boolean result = instance.checkDuplicate(t2);
        assertEquals(expResult, result);

    }

    /**
     * Test of checkDuplicate method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testCheckDuplicate_whenThereIsADuplicate() {
        System.out.println("checkDuplicate");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        LocalDate d = LocalDate.of(2023, Month.JUNE, 20);
        Task t1 = new Task("carl", "addition", d);
        instance.add(t1);
        boolean expResult = true;
        boolean result = instance.checkDuplicate(t1);
        assertEquals(expResult, result);

    }

    /**
     * Test of add method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testAdd_QueueIsEmpty() {
        System.out.println("add");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        LocalDate d = LocalDate.of(2023, Month.JUNE, 20);
        Task t1 = new Task("carl", "addition", d);
        int expResult = 0;
        int result = instance.add(t1);
        assertEquals(expResult, result);

    }

    /**
     * Test of add method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testAdd_WhenTaskIsAlreadyInTheQueue() {
        System.out.println("add");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        LocalDate d = LocalDate.of(2023, Month.JUNE, 20);
        Task t1 = new Task("carl", "addition", d);
        int expResult = 0;
        instance.add(t1);
        assertThrows(DuplicateElementException.class, () -> {
            instance.add(t1);
        });

    }

    /**
     * Test of add method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testAdd_WhenQueueIsFull() {
        System.out.println("add");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet(1);
        LocalDate d = LocalDate.of(2023, Month.JUNE, 20);
        Task t1 = new Task("carl", "addition", d);
        LocalDate d2 = LocalDate.of(2023, Month.JUNE, 21);
        Task t2 = new Task("cedric", "addition", d2);
        instance.add(t1);
        assertThrows(IllegalStateException.class, () -> {
            instance.add(t2);
        });

    }

    /**
     * Test of add method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testAdd_AddingInTheFirstPosition() {
        System.out.println("add");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        LocalDate d = LocalDate.of(2023, Month.JUNE, 20);
        Task t1 = new Task("carl", "addition", d);
        LocalDate d2 = LocalDate.of(2023, Month.JUNE, 19);
        Task t2 = new Task("cedric", "addition", d2);
        instance.add(t1);
        int expResult = 0;
        int result = instance.add(t2);
        assertEquals(expResult, result);
        int expSize = 2;
        assertEquals(expSize, instance.size());
    }

    /**
     * Test of add method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testAdd_AddingInTheLastPosition() {
        System.out.println("add");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        LocalDate d = LocalDate.of(2023, Month.JUNE, 20);
        Task t1 = new Task("carl", "addition", d);
        LocalDate d2 = LocalDate.of(2023, Month.JUNE, 19);
        Task t2 = new Task("cedric", "addition", d2);
        LocalDate d3 = LocalDate.of(2023, Month.JUNE, 21);
        Task t3 = new Task("caleb", "subtraction", d3);
        instance.add(t1);
        instance.add(t2);
        int expResult = 3;
        int result = instance.add(t3);
        assertEquals(expResult, result);
        int expSize = 3;
        assertEquals(expSize, instance.size());
    }

    /**
     * Test of add method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testAdd_AddingInTheMiddle() {
        System.out.println("add");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        LocalDate d = LocalDate.of(2023, Month.JUNE, 21);
        Task t1 = new Task("carl", "addition", d);
        LocalDate d2 = LocalDate.of(2023, Month.JUNE, 19);
        Task t2 = new Task("cedric", "addition", d2);
        LocalDate d3 = LocalDate.of(2023, Month.JUNE, 22);
        Task t3 = new Task("caleb", "subtraction", d3);
        LocalDate d4 = LocalDate.of(2023, Month.JUNE, 20);
        Task t4 = new Task("Ruth", "addition", d4);

        instance.add(t1);
        instance.add(t2);
        instance.add(t3);
        int expResult = 1;
        int result = instance.add(t4);
        assertEquals(expResult, result);
        int expSize = 4;
        assertEquals(expSize, instance.size());
    }

    /**
     * Test of add method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testAdd_AddingaTaskWithSameDeadline() {
        System.out.println("add");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        LocalDate d = LocalDate.of(2023, Month.JUNE, 20);
        Task t1 = new Task("carl", "addition", d);
        LocalDate d2 = LocalDate.of(2023, Month.JUNE, 19);
        Task t2 = new Task("cedric", "addition", d2);
        LocalDate d3 = LocalDate.of(2023, Month.JUNE, 21);
        Task t3 = new Task("caleb", "subtraction", d3);
        Task t4 = new Task("Naomi", "subtraction", d2);

        instance.add(t1);
        instance.add(t2);
        instance.add(t3);
        int expResult = 1;
        int result = instance.add(t4);
        assertEquals(expResult, result);
        int expSize = 4;
        assertEquals(expSize, instance.size());
    }

    /**
     * Test of peek method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testPeek_WhenQueueIsEmpty() {
        System.out.println("peek");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        assertThrows(NoSuchElementException.class, () -> {
            instance.peek();
        });

    }

    /**
     * Test of peek method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testPeek_WhenQueueIsNotEmpty() {
        System.out.println("peek");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        LocalDate d = LocalDate.of(2023, Month.JUNE, 21);
        Task t1 = new Task("carl", "addition", d);
        instance.add(t1);
        Task expTask = t1;
        Task result = instance.peek();
        assertEquals(expTask, result);

    }

    /**
     * Test of remove method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testRemove_WhenQueueIsNotEmpty() {
        System.out.println("remove");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        LocalDate d = LocalDate.of(2023, Month.JUNE, 21);
        Task t1 = new Task("carl", "addition", d);
        LocalDate d2 = LocalDate.of(2023, Month.JUNE, 19);
        Task t2 = new Task("cedric", "addition", d2);
        instance.add(t1);
        instance.add(t2);
        Task expResult = t2;
        Task result = instance.remove();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class BoundedPriorityQueueSet.
     */
    @Test
    public void testRemove_WhenQueueIsEmpty() {
        System.out.println("remove");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        assertThrows(NoSuchElementException.class, () -> {
            instance.remove();
        });
    }

}
