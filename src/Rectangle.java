import java.util.ArrayList;

/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-05-08
 */

/** this class create a rectangle.
 *
 * */
public class Rectangle {
    static final int CONST = 10;

    //members
    private Point upperLeft;
    private double width;
    private double height;
    private Line l1;
    private Line l2;
    private Line l3;
    private Line l4;



    /** Create a new rectangle with location and width/height.
     * @param upperLeftemp the upperlfet point of the rectangle
     * @param widthTemp the width of the rectangle
     * @param heightTemp the height of the rectangle
     * */
    public Rectangle(Point upperLeftemp, double widthTemp, double heightTemp) {
        this.upperLeft = upperLeftemp;
        this.width = widthTemp;
        this.height = heightTemp;
        this.l1 = new Line(upperLeftemp.getX(), upperLeftemp.getY() - CONST,
                upperLeftemp.getX() + widthTemp, upperLeftemp.getY() - CONST);
        this.l2 = new Line(upperLeftemp.getX() - CONST, upperLeftemp.getY(),
                upperLeftemp.getX() - CONST, upperLeftemp.getY() + heightTemp);
        this.l3 = new Line(upperLeftemp.getX(), upperLeftemp.getY() + heightTemp + CONST,
                upperLeftemp.getX() + widthTemp, upperLeftemp.getY() + heightTemp + CONST);
        this.l4 = new Line(upperLeftemp.getX() + widthTemp + CONST, upperLeftemp.getY(),
                upperLeftemp.getX() + widthTemp + CONST, upperLeftemp.getY() + height);

    }

    //
    /** Return a (possibly empty) List of intersection points.
     // with the specified line.
     * @param line line of the ball
     * @return list of intersction points between the rectangle and the line
     * */
    public java.util.List<Point> intersectionPoints(Line line) {
        java.util.List<Point> points = new ArrayList<Point>();
        if (this.getL1().isIntersecting(line)) {
            points.add(this.getL1().intersectionWith(line));
        }

        if (this.getL2().isIntersecting(line)) {
            points.add(this.getL2().intersectionWith(line));
        }
        if (this.getL4().isIntersecting(line)) {
            points.add(this.getL4().intersectionWith(line));
        }
        if (this.getL3().isIntersecting(line)) {
            points.add(this.getL3().intersectionWith(line));
        }
        return points;
    }

    //
    /** Return the width of the rectangle.
     *
     * @return the width of the rectangle
     * */
    public double getWidth() {
        return this.width;
    }

    /** Return the height of the rectangle.
     *
     * @return the height of the rectangle
     * */
    public double getHeight() {
        return this.height;
    }

    /** Return the uuperleft point of the rectangle.
     *
     * @return the upperleftpoint  of the rectangle
     * */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /** set the width of the rectangle.
     *
     * @param widthTemp the width of the rectangle
     * */
    public void setWidth(double widthTemp) {
        this.width = widthTemp;
    }

    /** set the height of the rectangle.
     *
     * @param heightTemp the height of the rectangle
     * */
    public void setHeight(double heightTemp) {
        this.height = heightTemp;
    }

    /** set the upperleft point of the rectangle.
     *
     * @param x the x value of the upperleft point
     * @param y the y value of the upperleft point
     * */
    public void setUpperLeft(double x, double y) {
        this.upperLeft.setX(x);
        this.upperLeft.setY(y);
    }

    /** Return the upperline the rectangle.
     *
     * @return the the upperline the rectangle
     * */
    public Line getL1() {
        return this.l1;
    }

    /** Return the left line the rectangle.
     *
     * @return the the left line the rectangle
     * */
    public Line getL2() {
        return this.l2;
    }

    /** Return the lower line the rectangle.
     *
     * @return the the lower line the rectangle
     * */
    public Line getL3() {
        return this.l3;
    }

    /** Return the right line the rectangle.
     *
     * @return the the right line the rectangle
     * */
    public Line getL4() {
        return this.l4;
    }
}
