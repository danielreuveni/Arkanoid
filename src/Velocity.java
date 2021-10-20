/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-04-11
 */

/** this method set velocity according to dx and dy.
 *
 * */
    public class Velocity {
        //members
        private double dx;
        private double dy;

        /** this method set velocity according to dx and dy.
         * @param dx velcoity according to dx
         * @param dy velcoity according to dy
         * */
        public Velocity(double dx, double dy) {
            this.dx = dx;
            this.dy = dy;
        }
        /** this method returns velocity according to dx and dy.
         * <p>
         *  the method calculate the new speed with trigonomeric operations
         * @param angle this method get the angle and the size of the speed
         * @param speed this method get the angle and the size of the speed
         * @return return the velocity according to dx and dy
         * */
        public static Velocity fromAngleAndSpeed(double angle, double speed) {
            double dx = speed * Math.cos(angle);
            double dy = speed * Math.sin(speed);
            if (angle == 0) {
                dx = 0;
                dy = -speed;
            }
            if (angle == 90) {
                dx = speed;
                dy = 0;
            }
            if (angle == 180) {
                dx = 0;
                dy = speed;
            }
            if (angle == 270) {
                dx = -speed;
                dy = 0;
            }
            return new Velocity(dx, dy);
        }

        //methods of get dx and dy of veloctiy
        /** this method get dx of velocity.
         * @return return the velocity according to dx
         * */
        public double getDX() {
            return this.dx;
        }
        /** this method get dy of velocity.
         * @return return the velocity according to dy
         * */
        public double getDY() {
            return this.dy;
        }

        //methods of set dx and dy of veloctiy
    /** this method set dx of velocity.
     * @param dxTemp velocity acoording to dx
     * */
        public void setDX(double dxTemp) {
            this.dx = dxTemp;
        }
    /** this method set dy of velocity.
     * @param dyTemp velocity acoording to dx
     * */
        public void setDY(double dyTemp) {
            this.dy = dyTemp;
        }
        /** this method get a point with position and return new point.
         * with position (x+dx, y+dy)
         * <p>
         * @param p this method get the point
         * @return return new point
         */
    public Point applyToPoint(Point p) {
        double x = p.getX() + dx;
        double y = p.getY() + dy;
            return new Point(x , y);
        }
    }