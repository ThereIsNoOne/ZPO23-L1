package list4;

public class Main {

    public static void main(String[] args) {
        ComplexNumber number = new ComplexNumber(4, 1);
        ComplexNumber newNumber = new ComplexNumber(5, 3.45);
        ComplexNumber zero = new ComplexNumber(0, 0);

        Vector2D vector = new Vector2D(4, 2);
        System.out.printf("Printing complex number Re(4), Im(1): %s\n", number);
        System.out.printf("Printing complex number Re(4), Im(1) in exponential form: %s\n", number.exponentialForm());
        System.out.printf("Number %s has: |z| = %f and arg(z) = %f radians\n",
                number,
                number.modulus(),
                number.argument());
        System.out.printf("%s + %s = %s\n", number, newNumber, number.add(newNumber));
        System.out.printf("%s + %s = %s\n", zero, vector, zero.add(vector));
        System.out.printf("%s + %s = %s\n", number, vector, ComplexNumber.add(number, vector));
        System.out.printf("%s + %s = %s\n", number, vector, Vector2D.add(number, vector));
        System.out.printf("%s * %d = %s\n", newNumber, 2, newNumber.multiply(2));
        System.out.printf("%s * %d = %s\n", newNumber, 2, ComplexNumber.multiply(newNumber, 2));
        System.out.printf("%s * %s = %s\n", newNumber, number, newNumber.multiply(number));
        System.out.printf("%s ^ %d = %s\n", newNumber, -2, newNumber.power(-2));
        System.out.printf("%s - %s = %s\n", zero, vector, zero.subtract(vector));
        System.out.printf("%s - %s = %s\n", zero, number, zero.subtract(number));
        System.out.printf("%s / %s = %s\n", number, newNumber, number.divide(newNumber));


        try {
            number.divide(zero);
        } catch (RuntimeException e) {
            System.out.println("Dividing by zero finished with:");
            //noinspection ThrowablePrintedToSystemOut
            System.out.println(e);
        }

        System.out.printf("Complex number from |z| = %f and arg(z) = %f: %s\n",
                4.0,
                3.14 / 4,
                ComplexNumber.fromPolar(4, 3.14 / 4));

        System.out.printf("%s == %s -> %b\n", newNumber, number, newNumber.equals(number));
        //noinspection EqualsWithItself
        System.out.printf("%s == %s -> %b\n", newNumber, newNumber, newNumber.equals(newNumber));
        //noinspection ConstantValue
        System.out.printf("%s == %s -> %b\n", newNumber, null, newNumber.equals(null));
        System.out.printf("%s == %s -> %b\n",
                newNumber,
                new ComplexNumber(5, 3.45),
                newNumber.equals(new ComplexNumber(5, 3.45)));

        ComplexNumber userNumber = ComplexNumberFactory.getComplexNumber();
        System.out.printf("User complex number is %s\n", userNumber);
    }


}
