package Arrays;
import java.util.Scanner;

/**  //Calculate the avarage temperature, and give how many days are above the average temperature

 1. take an input from the user (eg 8)
 2. prompt the user to enter all the 8 numbers
 3. calculate the average temperature
 4. Given the avarage tempeture, how many of the numbers in line 2 are above the average temperature */


public class AverageTemp {
    double arr[] = null;

    // Constructor
    public AverageTemp(int sizeOfArray) {
        arr = new double[sizeOfArray];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Double.MIN_VALUE;
        }
    }

    public void Insert(int location, double value) {
        try {
            if (arr[location] == Double.MIN_VALUE) {
                arr[location] = value;
                System.out.println("Successfully inserted " + value + " at location: " + location + "\n");
            } else {
                System.out.println("This cell is already occupied by another value.\n");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array!\n");
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the number of days
        System.out.println("Enter the number of days: ");
        int days = scanner.nextInt();

        // Prompt the user to enter the temperature for each day
        AverageTemp averageTemp = new AverageTemp(days);
        for (int i = 0; i < days; i++) {
            System.out.println("Enter the temperature for day " + (i + 1) + ": ");
            averageTemp.Insert(i, scanner.nextDouble());
        }

        // Calculate the average temperature
        double sum = 0;
        for (int i = 0; i < days; i++) {
            sum += averageTemp.arr[i];
        }
        double average = sum / days;
        System.out.println("The average temperature is: " + average);

        // Calculate the number of days above the average temperature
        int count = 0;
        for (int i = 0; i < days; i++) {
            if (averageTemp.arr[i] > average) {
                count++;
            }
        }
        System.out.println("The number of days above the average temperature is: " + count);
        scanner.close();

    }
    
    
}
