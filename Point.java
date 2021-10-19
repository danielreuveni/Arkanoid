/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-24-06
 */

/** this method set a new point according to x and y values.
 *
 * */
public class Point {

    //members / fields
    private double x;
    private double y;

    //set methods of x and y
    /** this method set x value of point.
     * @param xTemp point x value
     * */
    public void setX(double xTemp) {
        this.x = xTemp;
    }
    /** this method set y value of point.
     * @param yTemp point y value
     * */
    public void setY(double yTemp) {
        this.y = yTemp;
    }

    //constructor
    /** this method set point according to x y values.
     * @param x point x value
     * @param y point y value
     * */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /** this method return the distance betweet 2 points.
     * according to formula
     * <p>
     * @param other this method get the second point
     * @return return the distance of this point to the other point
     * */
    public double distance(Point other) {
        double d = Math.sqrt(Math.pow(this.getX() - other.getX(), 2) + Math.pow(this.getY() - other.getY(), 2));
        return d;
    }
    /** this method return if two points are equals.
     * <p>
     * @param other this method get the second point
     * @return return true if equal, false id not
     * */
    // equals -- return true is the points are equal, false otherwise
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        return this.x == other.x && this.y == other.y;
    }

    // Return the x and y values of this point
    /** this method get x value of the point.
     * @return return the x value of the point
     * */
    public double getX() {
        return this.x;
    }
    /** this method get y value of the point.
     * @return return the y value of the point
     * */
    public double getY() {
        return this.y;
    }
}




