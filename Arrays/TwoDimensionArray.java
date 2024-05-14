package Arrays;

public class TwoDimensionArray {
    int arr[][] = null;

    //Constructor
    public TwoDimensionArray(int numOfRows, int numOfCols) {
        this.arr = new int[numOfRows][numOfCols];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    // Insert method
    public void Insert(int row, int col, int value) {
        try {
            if (arr[row][col] == Integer.MIN_VALUE) {
                arr[row][col] = value;
                System.out.println("Successfully inserted " + value + " at location: " + row + ", " + col + "\n");
            } else {
                System.out.println("This cell is already occupied by another value.\n");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array!\n");
        }
    }

    // Traverse
    public void Traverse() {
        try {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Array does not exist!");
        }
    }

    public static void main(String[] args) {
        TwoDimensionArray tda = new TwoDimensionArray(0, 0);
    }
}
