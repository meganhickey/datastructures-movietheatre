import java.util.Scanner;

public class MovieTheater {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] seats = new char[5][5];

        // Make all seats available
        for (int row = 0; row < 5; row++) {
            for (int seat = 0; seat < 5; seat++) {
                seats[row][seat] = 'O';
            }
        }

        // Display seating chart
        System.out.println("Movie Theater Seating");
        System.out.println("O = Available, X = Reserved");

        for (int row = 0; row < 5; row++) {
            for (int seat = 0; seat < 5; seat++) {
                System.out.print(seats[row][seat] + " ");
            }

            System.out.println();
        }

        // Reserve seats
        while (true) {

            System.out.println("\nReserve a Seat");

            System.out.print("Enter row number (1-5): ");
            int row = scanner.nextInt();

            System.out.print("Enter seat number (1-5): ");
            int seat = scanner.nextInt();

            if (seats[row - 1][seat - 1] == 'O') {
                seats[row - 1][seat - 1] = 'X';
                System.out.println("Seat reserved!");
            } else {
                System.out.println("That seat is already reserved.");
            }

            // Display updated seating chart
            System.out.println("\nUpdated Seating Chart:");

            for (int r = 0; r < 5; r++) {
                for (int s = 0; s < 5; s++) {
                    System.out.print(seats[r][s] + " ");
                }
                System.out.println();
            }
        }
    }
}