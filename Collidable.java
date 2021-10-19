/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-08-05
 */

/**.
 * this interface sets methods to collidable object
 */
public interface Collidable {


    /** this return the "collision shape" of the object.
     *
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /** this method notify the object that we collided with it at collisionPoint with.
     // a given velocity.
     * @param collisionPoint the collision point between the object and the block
     * @param currentVelocity the current velocity of the object
     * @param hitter the object will hit
     * @return the new velocity
     * */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}