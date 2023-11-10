package list1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex1 {

    /**
     * Program calculates max height and range of throw.
     * User have to input velocity (m/s) and angle (deg).
     * @param args command line arguments.
     * @throws IllegalArgumentException when user input is invalid.
     */
    public static void main(String[] args) {
        double v0;
        double angle;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj prędkość: ");
        try {
            v0 = scanner.nextDouble();
        } catch (InputMismatchException exception){
            throw new IllegalArgumentException("Invalid input for velocity value.");
        }
        System.out.println("Podaj kąt uderzenia: ");
        try {
            angle = scanner.nextDouble();
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("Invalid input for angle value.");
        }
        double angle_radian = Math.toRadians(angle);

        scanner.close();

        if (v0 < 0 || angle < 0 || angle > 90) {
            System.out.println("Nieprawidłowe dane wejściowe.");
        } else {
            double distance = (Math.pow(v0, 2) * Math.sin(2 * angle_radian)) / 9.81;
            double maxHeight = (Math.pow(v0, 2) * Math.sin(angle_radian) * Math.sin(angle_radian) / (2 * 9.81));

            System.out.println("Zasięg: " + distance + " m");
            System.out.println("Maksymalna wysokość: " + maxHeight + " m");
        }
    }
}
