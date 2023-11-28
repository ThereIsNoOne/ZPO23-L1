package list7;

import list4.InvalidComplexNumberRepresentation;
import list4.Vector2D;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Represents complex number.
 */
public class ComplexNumber extends Vector2D {

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
        double newReal = Math.pow(modulus(), power) * Math.cos(argument() * power);
        double newImaginary = Math.pow(modulus(), power) * Math.sin(argument() * power);

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
            throw new ArithmeticException("Division by zero is not possible!");
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
        return new ComplexNumber(xCoordinate - otherVector.getXCoordinate(),
                yCoordinate- otherVector.getYCoordinate());
    }

    /**
     * Add other vector to `this` complex number.
     * @param otherNumber vector to add.
     * @return new ComplexNumber.
     */
    @Override
    public ComplexNumber add(Vector2D otherNumber) {
        return new ComplexNumber(otherNumber.getXCoordinate() + xCoordinate,
                yCoordinate + otherNumber.getYCoordinate());
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

    public static Optional<Map<Double, ComplexNumber>> readComplexData(String path) {
        File file = new File(path);

        if (!file.exists()) {
            return Optional.empty();
        }

        Map<Double, ComplexNumber> map = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while( (line = reader.readLine()) != null) {
                if (line.startsWith("#")) {
                    continue;
                }
                String[] parts = line.split(" ");
                Double time = Double.parseDouble(parts[0]);
                ComplexNumber number;
                try {
                    number = ComplexNumberFactory.getComplexNumber(parts[1]);
                } catch (InvalidComplexNumberRepresentation e) {
                    continue;
                }
                map.put(time, number);
            }

        } catch (IOException e) {
            return Optional.empty();
        }
        return Optional.of(map);
    }

    public static void processComplexData(String inputPath, boolean append) {
        processComplexData(inputPath, "./src/main/resources/out_data.out", append);
    }

    public static void processComplexData(String inputPath, String outputPath, boolean append) {
        Map<Double, ComplexNumber> map = readComplexData(inputPath).orElse(new TreeMap<>());
        Map<Double, Double[]> result = new TreeMap<>();
        for (Map.Entry<Double, ComplexNumber> entry : map.entrySet()) {
            Double[] modArg = new Double[2];
            modArg[0] = entry.getValue().modulus();
            modArg[1] = entry.getValue().argument();
            result.put(entry.getKey(), modArg);
        }
        writeComplexData(outputPath, result);
    }

    private static void writeComplexData(String outputPath, Map<Double, Double[]> result) {
        File outputFile = new File(outputPath);

        if (!outputFile.exists()) {
            try {
                Files.createFile(Paths.get(outputPath));
            } catch (IOException e) {
                throw new RuntimeException("Could not create file" + e.getMessage());
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            for (Map.Entry<Double, Double[]> entry : result.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue()[0] + " " + entry.getValue()[1]);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not write to file: " + e.getMessage());
        }
    }

}
