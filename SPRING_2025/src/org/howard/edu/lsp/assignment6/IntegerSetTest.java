package org.howard.edu.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class IntegerSetTest {

    @DisplayName("Test: Adding elements and avoiding duplicates")
    @Test
    public void testAddAndToString() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(5);
        set.add(3);
        assertEquals("[3, 5]", set.toString());
    }

    @DisplayName("Test: Clearing the set")
    @Test
    public void testClear() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals(0, set.length());
    }

    @DisplayName("Test: Checking number of elements after additions")
    @Test
    public void testLength() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(2);
        assertEquals(2, set.length());
    }

    @DisplayName("Test: Comparing two sets for equality")
    @Test
    public void testEquals() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(1);
        assertTrue(set1.equals(set2));
    }

    @DisplayName("Test: Checking for element presence")
    @Test
    public void testContains() {
        IntegerSet set = new IntegerSet();
        set.add(10);
        assertTrue(set.contains(10));
        assertFalse(set.contains(5));
    }

    @DisplayName("Test: Verifying largest and smallest elements")
    @Test
    public void testLargestAndSmallest() {
        IntegerSet set = new IntegerSet();
        set.add(7);
        set.add(3);
        set.add(9);
        assertEquals(9, set.largest());
        assertEquals(3, set.smallest());
    }

    @DisplayName("Test: Exception thrown on empty set when retrieving maximum value")
    @Test
    public void testLargestEmptySet() {
        IntegerSet set = new IntegerSet();
        Exception exception = assertThrows(IllegalStateException.class, set::largest);
        assertEquals("IntegerSet is empty.", exception.getMessage());
    }

    @DisplayName("Test: Exception thrown on empty set when retrieving minimum value")
    @Test
    public void testSmallestEmptySet() {
        IntegerSet set = new IntegerSet();
        Exception exception = assertThrows(IllegalStateException.class, set::smallest);
        assertEquals("IntegerSet is empty.", exception.getMessage());
    }

    @DisplayName("Test: Removing an element from the set")
    @Test
    public void testRemove() {
        IntegerSet set = new IntegerSet();
        set.add(4);
        set.add(6);
        set.remove(4);
        assertFalse(set.contains(4));
    }

    @DisplayName("Test: Merging two sets")
    @Test
    public void testUnion() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.union(set2);
        assertEquals("[1, 2, 3]", set1.toString());
    }

    @DisplayName("Test: Getting common elements between sets")
    @Test
    public void testIntersect() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.intersect(set2);
        assertEquals("[2]", set1.toString());
    }

    @DisplayName("Test: Subtracting common elements from a set")
    @Test
    public void testDiff() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set1.diff(set2);
        assertEquals("[1]", set1.toString());
    }

    @DisplayName("Test: Complementing a set with respect to a universal set")
    @Test
    public void testComplement() {
        ArrayList<Integer> universe = new ArrayList<>();
        universe.add(1);
        universe.add(2);
        universe.add(3);
        universe.add(4);

        IntegerSet universalSet = new IntegerSet(universe);
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(3);
        set.complement(universalSet);
        assertEquals("[2, 4]", set.toString());
    }

    @DisplayName("Test: Verifying if the set is empty")
    @Test
    public void testIsEmpty() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty());
        set.add(1);
        assertFalse(set.isEmpty());
    }
}
