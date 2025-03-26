package org.howard.edu.lsp.assignment5;

/**
 * Tests the functionality of the IntegerSet class.
 */
public class integerSetAssignment {

    /**
     * Main method where the program execution begins.
     * @param args command-line arguments 
     */
    public static void main(String[] args) {
        System.out.println("----- Testing IntegerSet -----\n");

        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Value of Set1: " + set1.toString());
        System.out.println("Smallest value in Set1: " + set1.smallest());
        System.out.println("Largest value in Set1: " + set1.largest());
        System.out.println();

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        System.out.println("Value of Set2: " + set2.toString());
        System.out.println();

        System.out.println("Union of Set1 and Set2:");
        System.out.println("Set1 before union: " + set1.toString());
        set1.union(set2);
        System.out.println("Result of union (Set1): " + set1.toString());
        System.out.println();

        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        System.out.println("Intersection of Set1 and Set2:");
        System.out.println("Set1 before intersection: " + set1.toString());
        System.out.println("Set2: " + set2.toString());
        set1.intersect(set2);
        System.out.println("Result of intersection (Set1): " + set1.toString());
        System.out.println();

        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Difference (Set1 - Set2):");
        System.out.println("Set1 before difference: " + set1.toString());
        System.out.println("Set2: " + set2.toString());
        set1.diff(set2);
        System.out.println("Result of difference (Set1): " + set1.toString());
        System.out.println();

        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Complement of Set1 with respect to Set2:");
        System.out.println("Set1: " + set1.toString());
        System.out.println("Universal Set (Set2): " + set2.toString());
        set1.complement(set2);
        System.out.println("Result of complement (Set1): " + set1.toString());
        System.out.println();

        IntegerSet set3 = new IntegerSet();
        set3.add(3);
        set3.add(4);
        set3.add(5);
        System.out.println("Does Set2 equal Set3? " + set2.equals(set3));
        set3.add(6);
        System.out.println("After adding 6 to Set3, does Set2 equal Set3? " + set2.equals(set3));
        System.out.println();

        IntegerSet set4 = new IntegerSet();
        System.out.println("Is Set4 empty? " + set4.isEmpty());
        set4.add(10);
        System.out.println("After adding an element, is Set4 empty? " + set4.isEmpty());
        System.out.println("Set4 before clear: " + set4.toString());
        set4.clear();
        System.out.println("Set4 after clear: " + set4.toString());
    }
}
