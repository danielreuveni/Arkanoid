import java.util.List;

/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-05-08
 */

public class Line {
    //members / fields
    private Point start;
    private Point end;
    private double m;
    private double b;

    // constructors
    /** this method set point named "start" and "End" to line.
     * @param start the start of the line
     * @param end the end of the line
     * */
    public Line(Point start, Point end) {
        this.start = new Point(start.getX(), start.getY());
        this.end = new Point(end.getX(), end.getY());
        //check and repair the x and y value
        //the point start might be left than the and point
        if (start.getX() > end.getX()) {
            Point temp;
            temp = new Point(0, 0);
            temp = this.start;
            this.start = this.end;
            this.end = temp;
            //this.m = this.m * (-1);
            this.b = this.b * (-1);
        }
        //constructor of slope and free organ

        if (this.getStart().getX() == this.getEnd().getX()) {
            this.m = 0;
            this.b = 0;
        } else {
            this.b = this.m * (-1) * this.start.getX() + this.start.getY();
            this.m = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
        }
    }
    //2nd constructor
    /** this method set point named "start" and "End" to line.
     * @param x1 the x value of point start
     * @param y1 the y value of point start
     * @param x2 the x value of point end
     * @param y2 the x value of point end
     **/
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        this.start.setX(x1);
        this.start.setY(y1);
        this.end.setX(x2);
        this.end.setY(y2);
        //check and repair the x and y value
        //the point start might be left than the and point
        if (start.getX() > end.getX()) {
            Point temp;
            temp = new Point(0, 0);
            temp = this.start;
            this.start = this.end;
            this.end = temp;
            this.m = this.m * (-1);
            this.b = this.b * (-1);
        }
        //constructor of slope and free organ

        if (this.getStart().getX() == this.getEnd().getX()) {
            this.m = 0;
            this.b = 0;
        } else {
            this.m = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
            this.b = this.m * (-1) * this.start.getX() + this.start.getY();
        }

    }

     /** this method return the length of line.
     * @return return the length of the line
     **/
     public double length() {
        double l = Math.sqrt(Math.pow(this.start.getX() - this.end.getX(), 2)
                + Math.pow(this.start.getY() - this.end.getY(), 2));
        return l;
    }

    /** this method return the middle between 2 points.
     * <p>
     * @return return the x,y value of the middle
     * */
    public Point middle() {
        double mx = (this.start.getX() + this.end.getX()) / 2;
        double my = (this.start.getY() + this.end.getY()) / 2;
        return new Point(mx, my);
    }

    /** this method Returns the start point of the line.
     * @return return the start point of the line
     * */
    public Point getStart() {
        return this.start;
    }

    /** this method Returns the end point of the line.
     * @return return the end point of the line
     * */
    public Point getEnd() {
        return this.end;
    }

    /** this method returns true if the lines intersect, false otherwise.
     * <p>
     * @param other this method get the second line
     * @return return true if intersect, false if not
     * */
    public boolean isIntersecting(Line other) {
        Point intersect = this.intersectionWith(other);
        if (intersect == null) {
            return false;
        }
        //check if the intersecting point is between two final sections
        return (this.start.getX() <= intersect.getX() && intersect.getX() <= this.end.getX()
                && other.start.getX() <= intersect.getX() && intersect.getX() <= other.end.getX())
                || (this.start.getY() <= intersect.getY() && intersect.getY() <= this.end.getY()
                && other.start.getY() <= intersect.getY() && intersect.getY() <= other.end.getY());
        }

    /** this method designed to round off decimal numbers.
     *
     * @param num the number we want to round off
     * @return the number round off or the real number
     */
    public static double roundDeviation(double num) {
        if (Math.abs(num - Math.rint(num)) < 0.001) {
            return Math.rint(num); //Return the rounded number
        } else {
            return num;
        }
    }
    /** Returns the intersection point if the lines intersect,
     // and null otherwise.
     * <p>
     * @param other this method get the second line
     * @return return the intersection point
     * */
    public Point intersectionWith(Line other) {
        double a1 = this.end.getY() - this.start.getY();
        double b1 = this.start.getX() - this.end.getX();
        double c1 = a1 * this.start.getX() + b1 * this.start.getY();
        double a2 = other.end.getY() - other.start.getY();
        double b2 = other.start.getX() - other.end.getX();
        double c2 = a2 * other.start.getX() + b2 * other.start.getY();
        double det = a1 * b2 - a2 * b1;
        if (det == 0) {
            return null;
        }
        double x = (b2 * c1 - b1 * c2) / det;
        double y = (a1 * c2 - a2 * c1) / det;
        x = roundDeviation(x);
        y = roundDeviation(y);
        Point intersectionPoint = new Point((float) (x), (float) (y));
        if (Math.min(this.start.getX(), this.end.getX()) <= intersectionPoint.getX()
                && intersectionPoint.getX() <= Math.max(this.start.getX(), this.end.getX())
                && Math.min(this.start.getY(), this.end.getY()) <= intersectionPoint.getY()
                && intersectionPoint.getY() <= Math.max(this.start.getY(), this.end.getY())
                && Math.min(other.start.getX(), other.end.getX()) <= intersectionPoint.getX()
                && intersectionPoint.getX() <= Math.max(other.start.getX(), other.end.getX())
                && Math.min(other.start.getY(), other.end.getY()) <= intersectionPoint.getY()
                && intersectionPoint.getY() <= Math.max(other.start.getY(), other.end.getY())) {
            return intersectionPoint;
        } else {
            return null;
        }
    }

    /**  return true is the lines are equal, false otherwise.
     * <p>
     * @param other this method get the second line
     * @return return true id equals, false if not
     * */
    // equals --
    public boolean equals(Line other) {
        return this.m == other.m && this.b == other.b;
    }

    /** this method return the closest intersection point to start of some line.
     *
     * @param rect rectangle.
     * @return the list of closest intersection points with the line and the
     * lines of rectangle
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List intersectionPointsList = rect.intersectionPoints(this);
        Point closestIntersectionPoint = null; //default initialization.
        if (intersectionPointsList.isEmpty()) {
            return null;
        }
        double minimalDistance = this.start.distance((Point) intersectionPointsList.get(0));
        closestIntersectionPoint = (Point) (intersectionPointsList.get(0));
        for (int i = 1; i < intersectionPointsList.size(); i++) {
            if (this.start.distance((Point) intersectionPointsList.get(i)) < minimalDistance) {
                minimalDistance = this.start.distance((Point) intersectionPointsList.get(i));
                closestIntersectionPoint = (Point) (intersectionPointsList.get(i));
            }
        }
        return closestIntersectionPoint;
    }


}