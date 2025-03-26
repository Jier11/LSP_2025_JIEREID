package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * IntegerSet: set of integers.
 */
public class IntegerSet {
   
    private List<Integer> set = new ArrayList<>();

    public IntegerSet() {
    }

    /**
     * Constructor that initializes set.
     * @param set initial  integer list 
     */
    public IntegerSet(ArrayList<Integer> set) {
        for (Integer num : set) {
            if (!this.set.contains(num)) {
                this.set.add(num);
            }
        }
    }

    /**
     * Clears internal representation of set
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns number of elements in set.
     *
     * @return the size of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if set is equal to another.
     * @param compares with
     * @return (true/false) if sets are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof IntegerSet))
            return false;
        IntegerSet other = (IntegerSet) o;
        if (this.length() != other.length())
            return false;
        return this.set.containsAll(other.set) && other.set.containsAll(this.set);
    }

    /**
     * Checks if set contains specific integer.
     *
     * @param value to check for
     * @return (true/false) if set contains value.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns largest element in set.
     *
     * @return largest integer
     * @throws IllegalStateException if empty
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("IntegerSet is empty.");
        }
        return Collections.max(set);
    }

    /**
     * Returns smallest element in set.
     * @return smallest integer
     * @throws IllegalStateException if empty
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("IntegerSet is empty.");
        }
        return Collections.min(set);
    }

    /**
     * Adds integer to set if its not already present.
     * @param item integer to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes integer from set if its present.
     * @param item integer to remove
     */
    public void remove(int item) {
        set.remove((Integer) item);
    }

    /**
     * Updates set to be the union of itself and the provided set.
     * @param intSetb set to union with
     */
    public void union(IntegerSet intSetb) {
        for (Integer num : intSetb.set) {
            this.add(num);
        }
    }

    /**
     * Updates set to be the intersection of itself and the provided set.
     * @param intSetb set to intersect with
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /**
     * Updates set to be the difference of itself and the provided set.
     * @param intSetb set to subtract from this set
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /**
     * Updates set to be the complement to the provided universal set.
     * @param intSetb universal set
     */
    public void complement(IntegerSet intSetb) {
        List<Integer> complement = new ArrayList<>();
        for (Integer num : intSetb.set) {
            if (!this.contains(num)) {
                complement.add(num);
            }
        }
        this.set = complement;
    }

    /**
     * Checks if set is empty.
     * @return (true/false) if there are no elements
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns set.
     * @return elements of set
     */
    @Override
    public String toString() {
        return set.toString();
    }
}
