package list4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ComplexNumberFactory {

    private static final Pattern pattern = Pattern.compile(
            "^-?[0-9]*\\.?[0-9]* *[+, -] *[ij]+[0-9]*\\.?[0-9]*$");

    public static ComplexNumber getComplexNumber(String complexNumberString) {
        if (!complexStringIsValid(complexNumberString)) {
            throw new InvalidComplexNumberRepresentation(String.format(
                    "Invalid complex number given. Was %s, should match (a + jb) pattern",
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

    private static double parseReal(String part, boolean isPositive) {
        try {
            return isPositive ? Double.parseDouble(part) : -1 * Double.parseDouble(part);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Invalid format for real part");
        }
    }

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

    public static ComplexNumber getComplexNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter complex number as (a + bi):");
        String complexString = scanner.nextLine();

        scanner.close();
        return getComplexNumber(complexString);
    }

    private static boolean complexStringIsValid(String complexString) {
        Matcher matcher = pattern.matcher(complexString);
        return matcher.matches();
    }
}
