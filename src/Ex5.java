import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex5 {

    /**
     * Program calculates equation of line going through two points, entered by user.
     * @param args command line arguments
     */
    public static void main(String[] args) {

        double pierwszyPunktX;
        double pierwszyPunktY;
        double drugiPunktX;
        double drugiPunktY;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj współrzędne pierwszego punktu: ");
        System.out.println("Współrzędna x");
        try {
            pierwszyPunktX = scanner.nextDouble();
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("Cannot parse entered number!");
        }
        System.out.println("Współrzędna y");
        try {
            pierwszyPunktY = scanner.nextDouble();
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("Cannot parse entered number!");
        }
        System.out.println("Podaj współrzędne drugiego punktu: ");
        System.out.println("Współrzędna x");
        try {
            drugiPunktX = scanner.nextDouble();
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("Cannot parse entered number!");
        }
        System.out.println("Współrzędna y");
        try {
            drugiPunktY = scanner.nextDouble();
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("Cannot parse entered number!");
        }

        scanner.close();

        try {
            double[] rowananie = wspolczynniki(pierwszyPunktX,
                    pierwszyPunktY,
                    drugiPunktX,
                    drugiPunktY);
            System.out.println("y = " + rowananie[0] + "x + " + rowananie[1]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Calculates coefficients of line connecting two points.
     * @param pierwszyPunktX x coordinate of first point.
     * @param pierwszyPunktY y coordinate of first point.
     * @param drugiPunktX x coordinate of second point.
     * @param drugiPunktY y coordinate of second point.
     * @return coefficients of line in form [a, b] where y = ax + b
     * @throws IllegalArgumentException when first point equals to second.
     */
    public static double[] wspolczynniki(double pierwszyPunktX,
                                         double pierwszyPunktY,
                                         double drugiPunktX,
                                         double drugiPunktY) {
        if ((drugiPunktX == pierwszyPunktX) && (drugiPunktY == pierwszyPunktY)){
            throw new IllegalArgumentException("Współrzędne punktów nie mogą być takie same.");
        }
        double a = (drugiPunktY - pierwszyPunktY) / (drugiPunktX - pierwszyPunktX);
        double b = pierwszyPunktY - (a * pierwszyPunktX);
        return new double[]{a, b};
    }
}
