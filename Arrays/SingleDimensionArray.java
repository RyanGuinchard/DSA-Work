package Arrays;

import java.util.Arrays;

/**
 * 1. insert into an array
 * 2. traverse an array
 * 3. Delete from array
 * 4. Search for an element in an array
 */

public class SingleDimensionArray {
    int arr[] = null;

    // Constructor
    public SingleDimensionArray(int sizeOfArray) {
        arr = new int[sizeOfArray];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
    }

    // Insert into an array
    public void insert(int location, int value) {
        try {
            if (arr[location] == Integer.MIN_VALUE) {
                arr[location] = value;
                System.out.println("Successfully inserted " + value + " at location: " + location + "\n");
            } else {
                System.out.println("This cell is already occupied by another value.\n");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array!\n");
        }
    }

    // Traverse an array
    public void traverseArray() {
        try {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println("Array no longer exists!\n");
        }
    }

    // Delete full array
    public void deleteArray() {
        arr = null;
        System.out.println("Array has been successfully deleted.\n");
    }

    // Delete from location
    public void delete(int location) {
        try {
            arr[location] = Integer.MIN_VALUE;
            System.out.println("Successfully deleted value at location: " + location + "\n");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array!\n");
        }
    }

    // Search for value in the array
    public void search(int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                System.out.println("Value " + value + " found at location " + i + "\n");
                return;
            }
        }
        System.out.println("Value " + value + " not found in the array.\n");
    }

    public static void main(String[] args) {
        SingleDimensionArray sda = new SingleDimensionArray(5);
        sda.insert(0, 1);
        sda.insert(1, 2);
        sda.insert(2, 3);
        sda.insert(3, 4);
        sda.insert(4, 5);
        sda.traverseArray();
        sda.delete(2);
        sda.traverseArray();
        sda.search(3);
        sda.deleteArray();
        System.out.println(Arrays.toString(sda.arr));
    }
}
