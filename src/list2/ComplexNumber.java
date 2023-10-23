package list2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Represents complex number.
 */
public class ComplexNumber extends Vector2D{

    /**
     * Initialize complex number object.
     * @param realPart real part of complex number.
     * @param imaginaryPart imaginary part of complex number.
     */
    public ComplexNumber(double realPart, double imaginaryPart) {
        super(realPart, imaginaryPart);
    }

    /**
     * Returns string representation of complex number.
     * @return string representation of complex nubmer.
     */
    @Override
    public String toString() {
        return String.format("%f + i%f", xCoordinate, yCoordinate);
    }

    /**
     * Returns exponential form of complex number.
     * @return string representation of complex number in exponential form.
     */
    public String exponentialForm() {
        return String.format("%fexp(i%f)", modulus(), argument());
    }

    /**
     * Calculates modulus of complex number. Works the same as `length` method.
     * @return modulus of complex number.
     */
    public double modulus() {
        return super.length();
    }

    /**
     * Returns argument of complex number. Works the same as `directionAngle` method.
     * @return argument of complex number.
     */
    public double argument() {
        return super.directionAngle();
    }

    /**
     * Calculates power of complex number (z^n).
     * @param power exponent of the power.
     * @return new complex number (z^n).
     */
    public ComplexNumber power(double power) {
        double newReal = Math.pow(modulus(), power) * Math.cos(power * Math.toRadians(argument()));
        double newImaginary = Math.pow(modulus(), power) * Math.sin(power * Math.toRadians(argument()));

        return new ComplexNumber(newReal, newImaginary);
    }

    /**
     * Calculates power of complex number (z^n).
     * @param number base of the power.
     * @param power exponent of the power.
     * @return new complex number (z^n).
     */
    public static ComplexNumber power(ComplexNumber number, double power) {
        return number.power(power);
    }

    /**
     * Multiplies two complex numbers.
     * @param other complex number to multiply by.
     * @return result of multiplication
     */
    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = xCoordinate * other.xCoordinate -
                yCoordinate * other.yCoordinate;
        double newImaginary = xCoordinate * other.yCoordinate +
                yCoordinate * other.xCoordinate;
        return new ComplexNumber(newReal, newImaginary);
    }

    /**
     * Divide two complex numbers.
     * @param other complex number, divider.
     * @return result of multiplication
     */
    public ComplexNumber divide(ComplexNumber other) {

        double denominator = Math.pow(other.xCoordinate, 2) + Math.pow(other.yCoordinate, 2);

        if (denominator == 0) {
            throw new RuntimeException("Division by zero is not possible!");
        }

        double newReal = xCoordinate * other.xCoordinate + yCoordinate * other.yCoordinate;
        double newImaginary = yCoordinate * other.xCoordinate - other.yCoordinate * xCoordinate;

        return new ComplexNumber(newReal/denominator, newImaginary/denominator);
    }

    /**
     * Divide two complex numbers.
     * @param nominator nominator.
     * @param denominator denominator.
     * @return result of division.
     * @throws RuntimeException when denominator is zero.
     */
    public static ComplexNumber divide(ComplexNumber nominator, ComplexNumber denominator) {
        return nominator.divide(denominator);
    }

    /**
     * Generates new complex number based on modulus and argument.
     * @param modulus modulus of complex number
     * @param argument argument of complex number (in radians)
     * @return new complex number.
     */
    public static ComplexNumber fromPolar(double modulus, double argument) {
        return new ComplexNumber(modulus * Math.cos(argument), modulus * Math.sin(argument));
    }

    /**
     * Multiplies complex number by double.
     * @param number number to multiply vector by.
     * @return result of multiplication.
     */
    @Override
    public ComplexNumber multiply(double number) {
        return new ComplexNumber(number * xCoordinate,
                number * yCoordinate);
    }

    /**
     * Subtract other vector from `this` and returns new ComplexNumber.
     * @param otherVector vector to subtract.
     * @return new ComplexNumber.
     */
    @Override
    public ComplexNumber subtract(Vector2D otherVector) {
        return new ComplexNumber(xCoordinate - otherVector.xCoordinate,
                yCoordinate- otherVector.yCoordinate);
    }

    /**
     * Add other vector to `this` complex number.
     * @param otherNumber vector to add.
     * @return new ComplexNumber.
     */
    @Override
    public ComplexNumber add(Vector2D otherNumber) {
        return new ComplexNumber(otherNumber.xCoordinate + xCoordinate,
                yCoordinate + otherNumber.yCoordinate);
    }

    /**
     * Compares two objects.
     * @param other object to compare.
     * @return true if all fields are matching, otherwise false
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        ComplexNumber otherNumber = (ComplexNumber) other;

        return xCoordinate == otherNumber.xCoordinate && yCoordinate == otherNumber.yCoordinate;
    }

    /**
     * Generates hash code, using MD5 algorithm..
     * @return hash code.
     */
    @Override
    public int hashCode() {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        messageDigest.update(String.format("%f %f", xCoordinate, yCoordinate).getBytes());
        byte[] digest = messageDigest.digest();

        return getHashSum(digest);
    }

    /**
     * Sums all bytes in bytes[] array.
     * @param digits bytes to sum.
     * @return sum of bytes.
     */
    private int getHashSum(byte[] digits) {
        int sum = 0;
        for (byte digit : digits) {
            sum += digit;
        }
        return sum;
    }

}
