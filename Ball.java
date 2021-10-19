/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-24-06
 */
import biuoop.DrawSurface;

    /** this class set bew ball.
    *
    */
public class Ball implements Sprite {
        //members
        private Point center;
        private int x;
        private int y;
        private int r;
        private java.awt.Color color;
        private Velocity v;
        private GameEnvironment gameEnvironment;

        // constructors
        /** this method set ball.
         * @param x the x value of the center of the ball
         * @param y the y value of the center of the ball
         * @param r the radius of the ball
         * @param color the color of the ball
         * */
        public Ball(int x, int y, int r, java.awt.Color color) {
            this.x = x;
            this.y = y;
            this.r = r;
            this.color = color;
            this.center = new Point(x , y);
            this.v = new Velocity(0 , 0);
        }

        //2nd constructor
        /** this method set ball.
         * @param center the x y values of the center of the ball.
         * @param r the radius of the ball
         * @param color the color of the ball
         * */
        public Ball(Point center, int r, java.awt.Color color) {
            this.center = center;
            this.center.setX((double) x);
            this.center.setY((double) y);
            this.r = r;
            this.color = color;
            this.v = new Velocity(0 , 0);

        }
        // methods of get x and get y
        /** this method get x of center point of the ball.
         * @return return the x of center point of the ball.
         * */
        public int getX() {
            return this.x;
        }
        /** this method get y of center point of the ball.
         * @return return the y of center point of the ball.
         * */
        public int getY() {
            return this.y;
        }

        /** this method returns the size of the ball.
         *
         * @return return the radius of the ball
         * */
        public int getSize() {
                return this.r;
        }

        /** this method returns the size of the ball.
         *
         * @return return the color of the ball
         * */
        public java.awt.Color getColor() {
            return this.color;
        }
        /** this method sets color to ball.
         * @param colorTemp color to the ball
         * */
        public void setColor(java.awt.Color colorTemp) {
            this.color = colorTemp;
        }

        /** this method sets the game environment of the ball to the ball.
         * @param gameEnvironmentTemp the game environment of the ball
         * */
        public void setGameEnvironment(GameEnvironment gameEnvironmentTemp) {
            this.gameEnvironment = gameEnvironmentTemp;
        }

        /** this method returns the game environment of the ball.
         * @return  the game environment of the ball
         * */
        public GameEnvironment getGameEnvironment() {
            return this.gameEnvironment;
        }

        /** this method returns the center of the ball.
         *
         * @return return the center of the ball
         * */
        public Point getCenter() {
            return this.center;
        }

        /** this method draw the ball on the given DrawSurface.
         * @param surface the screen
         * */
        public void drawOn(DrawSurface surface) {
            surface.setColor(this.getColor());
            surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
        }

        /** this method set velocity to the ball.
         * @param vTemp the velcoity according to type "Velocity"
         * */
        public void setVelocity(Velocity vTemp) {
            this.v.setDX(vTemp.getDX());
            this.v.setDY(vTemp.getDY());

        }

        /** this method set velocity to the ball.
         * @param dx velocity according to dx
         * @param dy velocity according to dy
         * */
        public void setVelocity(double dx, double dy) {
            this.v.setDX(dx);
            this.v.setDY(dy);
        }

        /** this method returns the velocity of the ball.
         *
         * @return return the velocity of the ball
         * */
        public Velocity getVelocity() {
            return this.v;
        }

        /** this method sets the game environment of the ball to the ball.
         * @param gameEnvironmentTemp the game environment of the ball
         * */
        public void setGameEnviroment(GameEnvironment gameEnvironmentTemp) {
            this.gameEnvironment = gameEnvironmentTemp;
        }

        /**
         * this method designed to override the original method signature.
         */
        public void moveOneStep() {

            Velocity velocityPerFrame = new Velocity(this.getVelocity().getDX(), this.getVelocity().getDY());
            Point start = new Point(0, 0);
            start = this.center;
            start.setY(start.getY());
            Point end = new Point(velocityPerFrame.applyToPoint(this.center).getX(),
                    velocityPerFrame.applyToPoint(this.center).getY());
            Line trajectory = new Line(start, end);
            if (this.gameEnvironment.getClosestCollision(trajectory) != null) {
                Point collisionPoint = this.gameEnvironment.getClosestCollision(trajectory).collisionPoint();
                Collidable collisionObject = this.gameEnvironment.getClosestCollision(trajectory).collisionObject();
                this.center = new Point(Math.ceil(collisionPoint.getX()
                        - positiveOrNegative(this.getVelocity().getDX())),
                        Math.ceil(collisionPoint.getY() - positiveOrNegative(this.getVelocity().getDY())));
                this.setVelocity(collisionObject.hit(this, collisionPoint, this.getVelocity()));
            } else {
                this.center = velocityPerFrame.applyToPoint(this.center);
            }
        }

        /** this method check if the ball is out of painted rectangle.
         * (like "move one step" method
         * <p>
         * @param a1 get x value of start boundary
         * @param a2 get y value of start boundary
         * @param b1 get x value of end boundary
         * @param b2 get y value of end boundary
         * @param height get the height of the screen
         * @param length get the length of the screen
         * */
        public void checkingBoundariesOfScreen(double a1, double a2, double b1, double b2,
                                               double height, double length) {
            //check if the boubadry of the rectangle is not equal
            //to the boundary of the screen
            if (length != a2) {
                if (this.getY() + this.r >= a2) {
                    double dyTemp = this.getVelocity().getDY();
                    this.v.setDY(-dyTemp);
                }
            }
            if (this.getY() - this.r <= a1) {
                double dyTemp = this.getVelocity().getDY();
                this.v.setDY(-dyTemp);
            }
            //check if the boubadry of the rectangle is not equal
            //to the boundary of the screen
            if (height != b2) {
                if (this.getX() + this.r >= b2) {
                    double dxTemp = this.getVelocity().getDX();
                    this.v.setDX(-dxTemp);
                }
            }
            if (this.getX() - this.r <= b1) {
                double dxTemp = this.getVelocity().getDX();
                this.v.setDX(-dxTemp);
            }
        }

        /** this method get a number and check if it is positive or not.
         *
         * @param number the number
         * @return the sign of the number
         */
        public static double positiveOrNegative(double number) {
            if (number > 0) {
                return 1;
            } else if (number == 0) {
                return 0;
            } else {
                return -1;
            }
        }

        /** this method call the moveonestep method.
         *
         */
        public void timePassed() {
            moveOneStep();
        }

        /** this method add the ball to the game.
         *
         * @param g the game
         */
        public void addToGame(Game g) {
            g.addSprite((Sprite) (this));
        }

        /** this method remove the ball to the game.
         *
         * @param game the game
         */
        public void removeFromGame(Game game) {
            game.removeSprite(this);
        }



    }

