import java.util.Scanner;

public class Ex3 {


    /**
     * Program to transfer HEX code to decimal values.
     * @param args command line arguments.
     * @throws IllegalArgumentException when HEX code is invalid.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj kod HEX: ");
        String k = scanner.nextLine();

        scanner.close();

        if (k.length() != 6){
            throw new IllegalArgumentException("HEX code have to have length of six.");
        }

        if (!isHexValid(k)) {
            throw new IllegalArgumentException("HEX code should contain only numbers from 0 to 9 and" +
                    "letters from a to f.");
        }
        String s1 = k.substring(0, 2);
        String s2 = k.substring(2, 4);
        String s3 = k.substring(4, 6);

        int r = Integer.parseInt(s1, 16);
        int g = Integer.parseInt(s2, 16);
        int b = Integer.parseInt(s3, 16);
        System.out.printf("(" + r + "," + g + "," + b + ")");

    }

    /**
     * Checks if the HEX code is valid (contains only char a-f and numbers 0-9).
     * @param value HEX code value.
     * @return true if is valid otherwise false.
     */
    private static boolean isHexValid(String value) {
        String reference = "0123456789abcdef";

        for (int i = 0; i < value.length(); i++) {
            if (reference.indexOf(value.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }
}
