package Arrays;

/*Method to display the seating chart. 
eg 0 represents an available seat, X represents a reserved seat

method to reserve a seat. If a seat is already reserved, 
tell use the seat is already taken. */

public class MovieTheater {
    private char[][] seats;

    public MovieTheater(int rows, int cols) {
        seats = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                seats[i][j] = '0';
        }
    }

    // Display seating chart
    public void displaySeats() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++)
                System.out.print(seats[i][j] + " ");
            System.out.println();
        }
    }

    // Reserve a seat
    public void reserveSeat(int row, int col) {
        if (seats[row][col] == '0') {
            seats[row][col] = 'X';
            System.out.println("Seat reserved successfully");
        } else
            System.out.println("Seat already taken");
    }

    public static void main(String[] args) {
        MovieTheater theater = new MovieTheater(5, 5);
        theater.displaySeats();
        theater.reserveSeat(2,3);
        theater.reserveSeat(0, 4);
        theater.displaySeats();
    }
}
