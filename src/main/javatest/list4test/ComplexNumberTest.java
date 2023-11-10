package main.javatest.list4test;


import list4.ComplexNumber;
import list4.ComplexNumberFactory;
import list4.InvalidComplexNumberRepresentation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ComplexNumberTest {

    ComplexNumber allPositiveComplexNumber = new ComplexNumber(1, 2);
    ComplexNumber allPositiveComplexNumberSecond = new ComplexNumber(4.2, 3.1);

    ComplexNumber allNegativeComplexNumber = new ComplexNumber(-1, -2);
    ComplexNumber allNegativeComplexNumberSecond = new ComplexNumber(-4.2, -3.1);

    ComplexNumber zeroNumber = new ComplexNumber(0, 0);

    double one = 1;

    double epsilon = 1e-3;


    @Test
    public void addPositivePositiveComplexTest() {
        assertEquals(allPositiveComplexNumber.add(allPositiveComplexNumberSecond),
                new ComplexNumber(5.2, 5.1));
    }

    @Test
    public void addPositiveNegativeComplexTest() {
        assertEquals(allPositiveComplexNumber.add(allNegativeComplexNumber) , new ComplexNumber(0 , 0));
    }

    @Test
    public void addNegativeNegativeComplexTest() {
        assertEquals(allNegativeComplexNumber.add(allNegativeComplexNumberSecond), new ComplexNumber(-5.2, -5.1));
    }

    @Test
    public void complexStringTest() {
        assertEquals(allPositiveComplexNumber.toString(), String.format("%f + i%f", 1.0, 2.0));
    }

    @Test
    public void complexExponential() {
        assertEquals(allPositiveComplexNumber.exponentialForm(), String.format("%fexp(i%f)", 2.236067977499, Math.atan(2)));
    }

    @Test
    public void positivePowerRealTest() {
        assertEquals(allPositiveComplexNumber.power(2).getXCoordinate(), -3, epsilon);
    }

    @Test
    public void positivePowerImaginaryTest() {
        assertEquals(allPositiveComplexNumber.power(2).getYCoordinate(), 4, epsilon);
    }

    @Test
    public void positiveNumberModulusTest() {
        assertEquals(allPositiveComplexNumber.modulus(), Math.sqrt(5));
    }

    @Test
    public void negativeNumberModulusTest() {
        assertEquals(allNegativeComplexNumber.modulus(), Math.sqrt(5));
    }

    @Test
    public void negativeArgumentTest() {

    }

    @Test
    public void positiveArgumentTest() {
        assertEquals(allPositiveComplexNumber.argument(), Math.toRadians(63.43), epsilon);
    }

    @Test
    public void negativePowerRealTest() {
        assertEquals(allNegativeComplexNumber.power(-2).getXCoordinate(), -0.12, epsilon);
    }

    @Test
    public void negativePowerImaginaryTest() {
        assertEquals(allNegativeComplexNumber.power(-2).getYCoordinate(), -0.16, epsilon);
    }

    @Test
    public void allPositiveComplexMultiplyTest() {
        assertEquals(allPositiveComplexNumber.multiply(allPositiveComplexNumberSecond),
                new ComplexNumber(-2, 11.5));
    }

    @Test
    public void allNegativeComplexMultiplyTest() {
        assertEquals(allNegativeComplexNumber.multiply(allNegativeComplexNumberSecond),
                new ComplexNumber(-2, 11.5));
    }

    @Test
    public void zeroComplexMultiplyTest() {
        assertEquals(allNegativeComplexNumber.multiply(zeroNumber),
                new ComplexNumber(0, 0));
    }

    @Test
    public void oneComplexMultiplyTest() {
        assertEquals(allNegativeComplexNumber.multiply(one),
                allNegativeComplexNumber);
    }

    @Test
    public void mixedComplexMultiplyTest() {
        assertEquals(allNegativeComplexNumber.multiply(allPositiveComplexNumberSecond),
                new ComplexNumber(2, -11.5));
    }

    @Test
    public void positiveComplexDivisionRealTest() {
        assertEquals(allPositiveComplexNumber.divide(allPositiveComplexNumberSecond).getXCoordinate(),
                (double) 208/545,
                epsilon);
    }

    @Test
    public void positiveComplexDivisionImaginaryTest() {
        assertEquals(allPositiveComplexNumber.divide(allPositiveComplexNumberSecond).getYCoordinate(),
                (double) 106/545,
                epsilon);
    }

    @Test
    public void negativeComplexDivisionRealTest() {
        assertEquals(allNegativeComplexNumber.divide(allNegativeComplexNumberSecond).getXCoordinate(),
                (double) 208/545,
                epsilon);
    }

    @Test
    public void negativeComplexDivisionImaginaryTest() {
        assertEquals(allNegativeComplexNumber.divide(allNegativeComplexNumberSecond).getYCoordinate(),
                (double) 106/545,
                epsilon);
    }

    @Test
    public void mixedComplexDivisionRealTest() {
        assertEquals(allNegativeComplexNumber.divide(allPositiveComplexNumberSecond).getXCoordinate(),
                (double) -208/545,
                epsilon);
    }

    @Test
    public void mixedComplexDivisionImaginaryTest() {
        assertEquals(allNegativeComplexNumber.divide(allPositiveComplexNumberSecond).getYCoordinate(),
                (double) -106/545,
                epsilon);
    }

    @Test
    public void zeroComplexDivisionRealTest() {
        assertThrows(ArithmeticException.class, () -> allPositiveComplexNumber.divide(zeroNumber));
    }

    @Test
    public void fromPolarRealTest() {
        assertEquals(ComplexNumber.fromPolar(4, Math.PI/4).getXCoordinate(),
                2*Math.sqrt(2),
                epsilon);
    }

    @Test
    public void fromPolarImaginaryTest() {
        assertEquals(ComplexNumber.fromPolar(4, Math.PI/4).getYCoordinate(),
                2*Math.sqrt(2),
                epsilon);
    }

    @Test
    public void multiplyByPositiveDoubleMoreThanOneTest() {
        assertEquals(allPositiveComplexNumberSecond.multiply(2),
                new ComplexNumber(8.4, 6.2));
    }

    @Test
    public void multiplyByNegativeDoubleTest() {
        assertEquals(allPositiveComplexNumberSecond.multiply(-2),
                new ComplexNumber(-8.4, -6.2));
    }

    @Test
    public void multiplyByPositiveDoubleLessThanOneTest() {
        assertEquals(allPositiveComplexNumberSecond.multiply(0.5),
                new ComplexNumber(2.1, 1.55));
    }

    @Test
    public void subPositivePositiveComplexTest() {
        assertEquals(allPositiveComplexNumber.subtract(allPositiveComplexNumberSecond),
                new ComplexNumber(-3.2, -1.1));
    }

    @Test
    public void subPositiveNegativeComplexTest() {
        assertEquals(allPositiveComplexNumber.subtract(allNegativeComplexNumber) , new ComplexNumber(2 , 4));
    }

    @Test
    public void subNegativeNegativeComplexTest() {
        assertEquals(allNegativeComplexNumber.subtract(allNegativeComplexNumberSecond), new ComplexNumber(3.2, 1.1));
    }

    @Test
    public void positiveComplexIFromStringSpaceTest() {
        assertEquals(ComplexNumberFactory.getComplexNumber("12.3 + j0.3"),
                new ComplexNumber(12.3, 0.3));
    }

    @Test
    public void positiveComplexJFromStringNoSpaceTest() {
        assertEquals(ComplexNumberFactory.getComplexNumber("12.3+j0.3"),
                new ComplexNumber(12.3, 0.3));
    }

    @Test
    public void mixedComplexIFromStringMixedSpaceTest() {
        assertEquals(ComplexNumberFactory.getComplexNumber("12.3- i0.3"),
                new ComplexNumber(12.3, -0.3));
    }

    @Test
    public void mixedComplexJFromStringMixedSpaceTest() {
        assertEquals(ComplexNumberFactory.getComplexNumber("-12 +j0.3"),
                new ComplexNumber(-12, 0.3));
    }

    @Test
    public void negativeComplexIFromStringSpaceTest() {
        assertEquals(ComplexNumberFactory.getComplexNumber("-12.3 - j3.3"),
                new ComplexNumber(-12.3, -3.3));
    }

    @Test
    public void invalidComplexFromStringTest() {
        assertThrows(InvalidComplexNumberRepresentation.class, () -> {
            ComplexNumberFactory.getComplexNumber("abc");
        });
    }

    @Test
    public void onlyRealComplexFromStringTest() {
        assertThrows(InvalidComplexNumberRepresentation.class, () -> {
            ComplexNumberFactory.getComplexNumber("1.2");
        });
    }

    @Test
    public void onlyImaginaryComplexFromStringTest() {
        assertThrows(InvalidComplexNumberRepresentation.class, () -> {
            ComplexNumberFactory.getComplexNumber("i9.8");
        });
    }

    @Test
    public void emptyComplexFromStringTest() {
        assertThrows(InvalidComplexNumberRepresentation.class, () -> {
            ComplexNumberFactory.getComplexNumber("");
        });
    }
}
