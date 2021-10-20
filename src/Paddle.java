/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-05-08
 */

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.awt.Color;


/** this class create a paddle that implements Sprite, Coliidable interfaces.
 *
 * */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private double left;
    private double right = 800;
    private int speed = 5;
    private GUI gui;

    /** this is a constructor of the paddle.
     * @param keyboard thekeyboard that control on the paddle
     * */
    public Paddle(biuoop.KeyboardSensor keyboard) {
        Point upperLeftemp = new Point(300, 540);
        this.rectangle = new Rectangle(upperLeftemp, 150, 30);
        this.keyboard = keyboard;
    }

    /** this method set the new location of the paddle.
     * @param point the new point
     * */
    public void setNewPoint(Point point) {
        this.rectangle = new Rectangle(point, this.rectangle.getWidth(), this.rectangle.getHeight());
    }

    /** this is method set the limits of the screen.
     * @param leftLimit the left limit of the screen
     * @param rightLimit the right limit of the screen
     * */
    public void setLimits(double leftLimit, double rightLimit) {
        this.left = leftLimit;
        this.right = rightLimit;
    }

    /** move the paddle to the left.
     *
     * */
    public void moveLeft() {
        double x = this.rectangle.getUpperLeft().getX() - this.speed;
        if (x >= this.left) {
            setNewPoint(new Point(x, this.rectangle.getUpperLeft().getY()));
        } else {
            setNewPoint(new Point(this.left, this.rectangle.getUpperLeft().getY()));
        }
    }

    /** move the paddle to the right.
     *
     * */
    public void moveRight() {
        double x = this.rectangle.getUpperLeft().getX() + this.speed;
        if (x + this.rectangle.getWidth() <= this.right) {
            setNewPoint(new Point(x, this.rectangle.getUpperLeft().getY()));
        } else {
            setNewPoint(new Point(this.right - this.rectangle.getWidth(), this.rectangle.getUpperLeft().getY()));
        }
        }

    /** move the paddle by the keyboard.
     *
     * */
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }
    /** this method draw the paddle in each frame.
     * @param d the surface
     * */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.darkGray);
        d.fillRectangle((int) (this.rectangle.getUpperLeft().getX()), (int) (this.rectangle.getUpperLeft().getY()),
                        (int) (this.rectangle.getWidth()), (int) (this.rectangle.getHeight()));
        d.setColor(Color.darkGray);
        d.drawRectangle((int) (this.rectangle.getUpperLeft().getX()), (int) (this.rectangle.getUpperLeft().getY()),
                (int) (this.rectangle.getWidth()), (int) (this.rectangle.getHeight()));
    }

    /** return the collidable.
     * @return collidable
     * */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /** this method return the new Velocity from the paddle according to five parts of its.
     * @param hitter the hitter ball
     * @param collisionPoint the collision point in the paddle.
     * @param currentVelocity the current velocity before the collision
     * @return the new velocity
     * */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (this.rectangle.getUpperLeft().getX()  <= collisionPoint.getX()
                && collisionPoint.getX() <= this.rectangle.getUpperLeft().getX() + (this.rectangle.getWidth() / 5)) {
            double speedTemp = 5;
            double angle = -60;
            Velocity v = Velocity.fromAngleAndSpeed(angle, speedTemp);
            return v;
        }
        if (this.rectangle.getUpperLeft().getX() + (this.rectangle.getWidth() / 5) <= collisionPoint.getX()
                && collisionPoint.getX() <= this.rectangle.getUpperLeft().getX()
                + 2 * (this.rectangle.getWidth() / 5)) {
            double speedTemp = 5;
            double angle = 330;
            Velocity v = Velocity.fromAngleAndSpeed(angle, speedTemp);
            return v;
        }
        if (this.rectangle.getUpperLeft().getX() + (2 * this.rectangle.getWidth() / 5) <= collisionPoint.getX()
                && collisionPoint.getX() <= this.rectangle.getUpperLeft().getX()
                + 3 * (this.rectangle.getWidth() / 5)) {
            double speedTemp = 5;
            double angle = 0;
            Velocity v = Velocity.fromAngleAndSpeed(angle, speedTemp);
            return v;
        }
        if (this.rectangle.getUpperLeft().getX() + (3 * this.rectangle.getWidth() / 5) <= collisionPoint.getX()
                && collisionPoint.getX() <= this.rectangle.getUpperLeft().getX()
                + 4 * (this.rectangle.getWidth() / 5)) {
            double speedTemp = 5;
            double angle = 30;
            Velocity v = Velocity.fromAngleAndSpeed(angle, speedTemp);
            return v;
        }
        if (this.rectangle.getUpperLeft().getX() + (4 * this.rectangle.getWidth() / 5) <= collisionPoint.getX()
                && collisionPoint.getX() <= this.rectangle.getUpperLeft().getX() + (this.rectangle.getWidth())) {
            double speedTemp = 5;
            double angle = 120;
            Velocity v = Velocity.fromAngleAndSpeed(angle, speedTemp);
            return v;
        } else {
            return currentVelocity;
        }
    }

    /** Add this paddle to the game.
     * @param g the game
     * */
    public void addToGame(Game g) {
        g.addSprite((Sprite) (this));
        g.addCollidable((Collidable) (this));
    }
}