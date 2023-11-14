package list4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class responsible for creating new instances of complex number class.
 */
public final class ComplexNumberFactory {

    /**
     * Pattern that string have to match in order to be processed.
     */
    private static final Pattern pattern = Pattern.compile(
            "^-?[0-9]*\\.?[0-9]* *[+, -] *[ij]+[0-9]*\\.?[0-9]*$");

    /**
     * Creates a new instance of a complex number based on input string.
     * @param complexNumberString input string to be processed.
     * @return new instance of a complex number.
     * @throws InvalidComplexNumberRepresentation when input string do not match
     *                                            the pattern.
     */
    public static ComplexNumber getComplexNumber(String complexNumberString) {
        if (!complexStringIsValid(complexNumberString)) {
            throw new InvalidComplexNumberRepresentation(String.format(
                    "Invalid complex number given. Was %s, should match a + jb pattern",
                    complexNumberString
            ));
        }
        boolean isAddition = complexNumberString.contains("+");

        String[] parts = isAddition ?
                complexNumberString.split("\\+") : complexNumberString.split("-");
        int length = parts.length;
        boolean isPositiveReal = length == 2;

        double realPart = parseReal(parts[length - 2].trim(), isPositiveReal);
        double imaginaryPart = parseImaginary(parts[length - 1].trim(), isAddition);

        return new ComplexNumber(realPart, imaginaryPart);
    }

    /**
     * Parse real part of the complex number
     * @param part string representation of real part of the complex number.
     * @param isPositive true if real part is positive, false otherwise
     * @return real part of the complex number.
     * @throws NumberFormatException when string is invalid to be converted to
     *                               double
     */
    private static double parseReal(String part, boolean isPositive) {
        try {
            return isPositive ? Double.parseDouble(part) : -1 * Double.parseDouble(part);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Invalid format for real part");
        }
    }

    /**
     * Parse imaginary part of the complex number
     * @param part string representation of imaginary part of the complex number.
     * @param isPositive true if imaginary part is positive, false otherwise
     * @return imaginary part of the complex number.
     * @throws NumberFormatException when string is invalid to be converted to
     *                               double
     */
    private static double parseImaginary(String part, boolean isPositive) {
        // Removing leading imaginary unit
        part = part.substring(1);
        try {
            return isPositive ?
                    Double.parseDouble(part) : -1 * Double.parseDouble(part);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Invalid format for imaginary part");
        }
    }

    /**
     * Creates a new instance of complex number, based on user input.
     * @return a new instance of complex number.
     */
    public static ComplexNumber getComplexNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter complex number as (a + bi):");
        String complexString = scanner.nextLine();

        scanner.close();
        return getComplexNumber(complexString);
    }

    /**
     * Checks if input string matches the pattern.
     * @param complexString string to check.
     * @return true if matches, false otherwise.
     */
    private static boolean complexStringIsValid(String complexString) {
        Matcher matcher = pattern.matcher(complexString);
        return matcher.matches();
    }
}
