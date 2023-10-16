import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex6 {

    /**
     * Program to print date (given by user) in format DD-MM-YYYY.
     * @param args command line arguments.
     * @throws IllegalArgumentException when input is not a number.
     */
    public static void main(String[] args) {
        int dzien;
        int miesiac;
        int rok;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj dzień, miesiąc oraz rok: ");
        try{

            dzien = scanner.nextInt();
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("Day has to be an integer.");
        }
        try{

            miesiac = scanner.nextInt();
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("Month has to be an integer.");
        }
        try{

            rok = scanner.nextInt();
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("Year has to be an integer.");
        }

        try {
            String data2 = data(dzien, miesiac, rok);
            System.out.println(data2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns date from given day, month and year in format DD-MM-YYYY.
     * @param dzien day of the month.
     * @param miesiac month of the year.
     * @param rok year.
     * @return formatted date.
     * @throws IllegalArgumentException When day or month are invalid (i.e. do not exist).
     */
    public static String data(int dzien, int miesiac, int rok) {
        int dopuszczalnyDzien = 31;

        if (miesiac < 1 || miesiac > 12) {
            throw new IllegalArgumentException("Podano nieprawidlowy miesiac");
        }

        if (miesiac == 4 || miesiac == 6 || miesiac == 9 || miesiac == 11) {
            dopuszczalnyDzien = 30;
        }

        if (miesiac == 2 && rok % 4 == 0) {
            dopuszczalnyDzien = 29;
        } else if (miesiac == 2 && rok % 4 != 1) {
            dopuszczalnyDzien = 28;
        }

        if ((dzien < 1) || (dzien > dopuszczalnyDzien)) {
            throw new IllegalArgumentException("Podano nieprawidłowy dzień.");
        }

        String nowyDzien = String.format("%02d", dzien);
        String nowyMiesiac = String.format("%02d", miesiac);
        return nowyDzien + "-" + nowyMiesiac + "-" + rok;
    }
}
