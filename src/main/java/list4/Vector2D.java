package list4;

/**
 * Represents 2D vector.
 */
public class Vector2D {
    protected double xCoordinate;
    protected double yCoordinate;

    /**
     * Initializes 2D vector [x, y].
     * @param xCoordinate first coordinate.
     * @param yCoordinate second coordinate.
     */
    public Vector2D(double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * Calculates length of the vector.
     * @return length of the vector.
     */
    public double length() {
        return Math.sqrt(Math.pow(xCoordinate, 2) + Math.pow(yCoordinate, 2));
    }

    /**
     * Calculates angle (in radians) between vector and OX axis.
     * @return angle in radians between vector and OX axis.
     */
    public double
    directionAngle() {
        return Math.atan(yCoordinate /xCoordinate);
    }

    /**
     * Adds two vectors.
     * @param otherVector vector to add.
     * @return sum of two vectors.
     */
    public Vector2D add(Vector2D otherVector) {
        return new Vector2D(xCoordinate + otherVector.xCoordinate,
                yCoordinate + otherVector.yCoordinate);
    }

    /**
     * Calculates sum of two vectors.
     * @param vector first vector.
     * @param otherVector second vector.
     * @return sum of first and second vector.
     * @param <T> type of vector.
     */
    public static <T extends Vector2D> T add(T vector, Vector2D otherVector) {
        return (T) vector.add(otherVector);
    }

    /**
     * Subtracts two vectors.
     * @param otherVector vector to subtract.
     * @return result of subtraction
     */
    public Vector2D subtract(Vector2D otherVector) {
        return new Vector2D(xCoordinate - otherVector.xCoordinate,
                yCoordinate - otherVector.yCoordinate);
    }

    /**
     * Subtracts two vectors.
     * @param vector first vector.
     * @param otherVector second vector.
     * @return result of subtracting second vector from first vector.
     * @param <T> type of vector.
     */
    public  static <T extends Vector2D> T subtract(T vector, Vector2D otherVector) {
        return (T) vector.subtract(otherVector);
    }

    /**
     * Multiply vector by number.
     * @param number number to multiply vector.
     * @return result of multiplication.
     */
    public Vector2D multiply(double number) {
        return new Vector2D(number * xCoordinate,
                number * yCoordinate);
    }

    /**
     * Multiplies vector by number.
     * @param vector vector to multiply.
     * @param number number to multiply by.
     * @return result of multiplication.
     * @param <T> type of vector.
     */
    public static <T extends Vector2D> T multiply(T vector, double number) {
        return (T) vector.multiply(number);
    }

    /**
     * Get vector from it's polar coordinates.
     * @param length length of the vector
     * @param angle direction angle in radians
     * @return Vector from polar coordinates
     */
    public static Vector2D fromPolar(double length, double angle) {
        return new Vector2D(length * Math.cos(angle), length * Math.sin(angle));
    }

    /**
     * Getter for xCoordinate.
     * @return xCoordinate.
     */
    public double getXCoordinate() {
        return xCoordinate;
    }

    /**
     * Getter for yCoordinate.
     * @return yCoordinate.
     */
    public double getYCoordinate() {
        return yCoordinate;
    }

    /**
     * Setter for xCoordinate.
     * @param xCoordinate new xCoordinate.
     */
    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Setter for yCoordinate.
     * @param yCoordinate new yCoordinate.
     */
    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     * Returns string representation of vector.
     * @return string representation of vector.
     */
    @Override
    public String toString() {
        return String.format("[%f, %f]", xCoordinate, yCoordinate);
    }
}
