
/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-05-08
 */

/** this class stores info about the collidable object and the collision point.
 *
 */
public class CollisionInfo {
    //members
    private Point collisionPoint;
    private Collidable collisionObject;
    private java.util.List<Collidable> colli;
    private Line ballLine;

    /** the constructor of the collision info.
     *
     * @param collisionPointTemp the collision point
     * @param collisionObjectTemp the collidable object
     */
    public CollisionInfo(Point collisionPointTemp, Collidable collisionObjectTemp) {
        this.collisionObject = collisionObjectTemp;
        this.collisionPoint = collisionPointTemp;
    }

    /** this method is a constructor that designed for tests.
     *
     * @param ballLine nothing
     * @param colli nothing
     */
    public CollisionInfo(Line ballLine, java.util.List<Collidable> colli) {
        this.colli = colli;
        this.ballLine = ballLine;
    }

    /** this method return the point at which the collision occurs.
     *
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /** this method return the collidable object involved in the collision.
     *
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}