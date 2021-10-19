import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-05-08
 */

        /** this class create a block that implements Sprite, Coliidable interfaces.
        *
        * */
public class Block implements Collidable, Sprite, HitNotifier {
    //members
    private Rectangle rectangle;
    private java.awt.Color color;
    private GameEnvironment gameEnvironment;
    private List<HitListener> hitListeners = new ArrayList();
    private int hits;


            /** this is a constructor of the block.
             * @param rectangle the rectangle form of the block
             * @param color the color of the block
             * */
    public Block(Rectangle rectangle, java.awt.Color color) {
        this.rectangle = rectangle;
        this.color = color;
    }
    /** this is a constructor of random block.
    * @param randomRectangle the random rectangle form of the block
    * */
    public Block(Rectangle randomRectangle) {
        Random rand = new Random();
        double x = rand.nextInt(800 - 2) + 1;
        double y = rand.nextInt(600 - 2) + 1;
        this.rectangle.setUpperLeft(x , y);
        this.rectangle.setWidth(rand.nextInt(800 - (int) x - 1) + 1);
        this.rectangle.setHeight(rand.nextInt(600 - (int) y - 1) + 1);
        this.color = Color.orange;
    }

    // Return the "collision shape" of the object.
    /** this method return the "collision shape" of the object.
    * @return the rectangle fom of the block
    * */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }


    /** this method notify the object that we collided with it at collisionPoint with/
     // a given velocity.
     * @param hitter the hitter ball
    * @param collisionPoint the collision point between the object and the block
     * @param currentVelocity the current velocity of the object
     * @return the new velocity
    * */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        if (this.rectangle.getUpperLeft().getX() == Math.ceil(collisionPoint.getX())
                && this.rectangle.getUpperLeft().getY() == Math.ceil(collisionPoint.getY())) {
            return new Velocity(-currentVelocity.getDX(), -currentVelocity.getDY());
        }
        if (this.rectangle.getUpperLeft().getX() == Math.ceil(collisionPoint.getX())
                && this.rectangle.getUpperLeft().getY() + rectangle.getHeight() == Math.ceil(collisionPoint.getY())) {
            return new Velocity(-currentVelocity.getDX(), -currentVelocity.getDY());
        }
        // if there is collision between the object aand the lower line
        if (this.rectangle.getL3().getStart().getX() <= collisionPoint.getX()
                && collisionPoint.getX() <= this.rectangle.getL3().getEnd().getX()
                && collisionPoint.getY() == this.rectangle.getL3().getStart().getY()
                && collisionPoint.getY() == this.rectangle.getL3().getEnd().getY()) {
            if (currentVelocity.getDX() > 0 && currentVelocity.getDY() < 0) {
                return new Velocity(currentVelocity.getDX(), -currentVelocity.getDY());
            }
            if (currentVelocity.getDX() < 0 && currentVelocity.getDY() < 0) {
                return new Velocity(currentVelocity.getDX(), -currentVelocity.getDY());
            }
            if (currentVelocity.getDX() == 0 && currentVelocity.getDY() < 0) {
                return new Velocity(currentVelocity.getDX(), -currentVelocity.getDY());
            }
        }
        // if there is collision between the object and the upper line
        if (this.rectangle.getL1().getStart().getX() <= collisionPoint.getX()
                && collisionPoint.getX() <= this.rectangle.getL1().getEnd().getX()
                && collisionPoint.getY() == this.rectangle.getL1().getStart().getY()
                && collisionPoint.getY() == this.rectangle.getL1().getEnd().getY()) {
            if (currentVelocity.getDX() > 0 && currentVelocity.getDY() > 0) {
                return new Velocity(currentVelocity.getDX(), -currentVelocity.getDY());
            }
            if (currentVelocity.getDX() < 0 && currentVelocity.getDY() > 0) {
                return new Velocity(currentVelocity.getDX(), -currentVelocity.getDY());
            }
            if (currentVelocity.getDX() == 0 && currentVelocity.getDY() > 0) {
                return new Velocity(currentVelocity.getDX(), -currentVelocity.getDY());
            }
        }
        // if there is collision between the object and the right line
        if (this.rectangle.getL2().getStart().getY() <= collisionPoint.getY()
                && collisionPoint.getY() <= this.rectangle.getL2().getEnd().getY()
                && collisionPoint.getX() == this.rectangle.getL2().getStart().getX()
                && collisionPoint.getX() == this.rectangle.getL2().getEnd().getX()

        ) {
            if (currentVelocity.getDX() > 0 && currentVelocity.getDY() > 0) {
                return new Velocity(-currentVelocity.getDX(), currentVelocity.getDY());
            }
            if (currentVelocity.getDX() > 0 && currentVelocity.getDY() < 0) {
                return new Velocity(-currentVelocity.getDX(), currentVelocity.getDY());
            }
            if (currentVelocity.getDX() > 0 && currentVelocity.getDY() == 0) {
                return new Velocity(-currentVelocity.getDX(), currentVelocity.getDY());
            }
        }
        // if there is collision between the object and the left line
        if (this.rectangle.getL4().getStart().getY() <= collisionPoint.getY()
                && collisionPoint.getY() <= this.rectangle.getL4().getEnd().getY()
                && collisionPoint.getX() == this.rectangle.getL4().getStart().getX()
        ) {
            if (currentVelocity.getDX() < 0 && currentVelocity.getDY() < 0) {
                return new Velocity(-currentVelocity.getDX(), currentVelocity.getDY());
            }
            if (currentVelocity.getDX() < 0 && currentVelocity.getDY() > 0) {
                return new Velocity(-currentVelocity.getDX(), currentVelocity.getDY());
            }
            if (currentVelocity.getDX() < 0 && currentVelocity.getDY() == 0) {
                return new Velocity(-currentVelocity.getDX(), currentVelocity.getDY());
            }

        }

        return new Velocity(currentVelocity.getDX(), currentVelocity.getDY());

    }

    /** Return the color of the block.
     *
     * @return the color of the block
     * */
    public java.awt.Color getColor() {
        return this.color;
    }

            /** this method draw the block on the screen.
             *
             * @param surface the surface
             */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.black);
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        surface.setColor(this.getColor());
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX() + 1,
                (int) this.rectangle.getUpperLeft().getY() + 1,
                (int) this.rectangle.getWidth() - 2, (int) this.rectangle.getHeight() - 2);
    }
    /**.
    *this method notify the block that time passed
    */
    public void timePassed() {

    }
    /** this method add the sprites and collidable objects to the game.
    * @param g the game
    */
    public void addToGame(Game g) {
        g.addSprite((Sprite) (this));
        g.addCollidable((Collidable) (this));
    }
            /** this method remove the ball to the game.
             *
             * @param game the game
             */
            public void removeFromGame(Game game) {
                game.removeSprite((Sprite) (this));
                game.removeCollidable((Collidable) (this));
            }

            /** this method add the hitlistener object to the game envirionment.
             *
             * @param hl the hitlistener object
             */
            public void addHitListener(HitListener hl) {
                this.hitListeners.add(hl);
            }

            /** this method remove the hitlustener object from the game environment.
             *
             * @param hl the hitlisterner object
             */
            public void removeHitListener(HitListener hl) {
                this.hitListeners.remove(hl);
            }

            /** this method notify to all listeners objects about hit event.
             *
             * @param hitter the hitter ball
             */
            private void notifyHit(Ball hitter) {
                List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
                for (HitListener hl : listeners) {
                    hl.hitEvent(this, hitter);
                    hitter.getGameEnvironment().removeCollidable(this);

                }
            }

            /** this method set the number of hits to the field.
             *
             * @param number the number of hits
             */
            public void setNumberOfHits(int number) {
                this.hits = number;
            }

            /** this method get the number of hits.
             *
             * @return the number of hits
             */
            public int getNumberOfHits() {
                return this.hits;
            }

        }
