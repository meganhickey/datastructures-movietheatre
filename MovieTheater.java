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

        // Display initial seating chart
        System.out.println("Movie Theater Seating");
        System.out.println("O = Available, X = Reserved");

        for (int row = 0; row < 5; row++) {
            for (int seat = 0; seat < 5; seat++) {
                System.out.print(seats[row][seat] + " ");
            }
            System.out.println();
        }

        boolean running = true;

        while (running) {

            // Display menu
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Reserve a seat");
            System.out.println("2. Cancel a reservation");
            System.out.println("3. Display seating chart");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            // Reserve a seat
            if (choice == 1) {

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

                    // Find an available seat
                    boolean foundSeat = false;

                    for (int r = 0; r < 5; r++) {
                        for (int s = 0; s < 5; s++) {

                            if (seats[r][s] == 'O' && foundSeat == false) {
                                System.out.println("Available seat: Row "
                                        + (r + 1) + ", Seat " + (s + 1));

                                foundSeat = true;
                            }
                        }
                    }
                }
            }

            // Cancel a reservation
            else if (choice == 2) {

                System.out.println("\nCancel a Reservation");

                System.out.print("Enter row number (1-5): ");
                int row = scanner.nextInt();

                System.out.print("Enter seat number (1-5): ");
                int seat = scanner.nextInt();

                if (seats[row - 1][seat - 1] == 'X') {
                    seats[row - 1][seat - 1] = 'O';
                    System.out.println("Reservation cancelled!");

                } else {
                    System.out.println("That seat is not reserved.");
                }
            }

            // Display seating chart
            else if (choice == 3) {

                System.out.println("\nCurrent Seating Chart:");

                for (int r = 0; r < 5; r++) {
                    for (int s = 0; s < 5; s++) {
                        System.out.print(seats[r][s] + " ");
                    }
                    System.out.println();
                }
            }

            // Exit program
            else if (choice == 4) {

                System.out.println("Goodbye!");
                running = false;
            }

            // Invalid menu choice
            else {
                System.out.println("Invalid choice.");
            }

            // Display updated chart after reserving or cancelling
            if (choice == 1 || choice == 2) {

                System.out.println("\nUpdated Seating Chart:");

                for (int r = 0; r < 5; r++) {
                    for (int s = 0; s < 5; s++) {
                        System.out.print(seats[r][s] + " ");
                    }
                    System.out.println();
                }
            }
        }

        scanner.close();
    }
}