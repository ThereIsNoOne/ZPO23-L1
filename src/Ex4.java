import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex4 {

    /**
     * Program prints out to console multiplication table, for range [0, n], where n is integer
     * entered by user.
     * @param args command line arguments.
     * @throws IllegalArgumentException when input cannot be transformed into integer.
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj liczbę całkowitą z przedziału [1,9]: ");
        int n;
        try {
            n = scanner.nextInt();
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("Entered value is not an integer");
        }
        scanner.close();

        if ((n > 9) || (n < 1)) {
            System.out.print("Podano liczbę spoza dopuszczalnego przedziału.");
        } else {
            int[][] tabA = new int[n+1][n+1];

            StringBuilder separator = new StringBuilder("----");
            System.out.print(" \t");
            for (int i = 0; i<= n; i++) {
                System.out.print(i + "\t");
                separator.append("----");
            }
            System.out.println();
            System.out.println(separator);

            for (int i = 0; i <= n; i++) {
                System.out.print(i + "|\t");
                for (int j = 0; j <= n; j++) {
                    tabA[i][j] = i * j;
                    System.out.print(tabA[i][j] + "\t");
                }
                System.out.println();
            }

        }
    }
}



