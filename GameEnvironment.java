/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-04-11
 */
import java.util.ArrayList;
import java.util.List;

/** this class designed to control on the game environment of each object.
 *
 */
public class GameEnvironment {
    //members
    private java.util.List<Collidable> collidables;

    /** the constructor of the game environment.
     * initalize array list of collidables objects to game environment
     *
     */
    public GameEnvironment() {
        this.collidables =  new ArrayList<Collidable>();
    }

    /** this method add the given collidable to the environment.
     *
     * @param c the collidable object
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /** this method remove the collidable objects from the game environment.
     * @param c the coliidable objects
     */
    public void deleteCollidable(Collidable c) {
        this.collidables.remove(c);
    }


    /** this method remove the given collidable from the environment.
     *
     * @param c the collidable object
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }

    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.

     /** Assume an object moving from line.start() to line.end().
     // If this object will not collide with any of the collidables
     // in this collection, return null. Else, return the information
     // about the closest collision that is going to occur.
     *
     * @param trajectory the trajectory of the ball in each frame
     * @return collision info of the closest collidable object
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        int i, j = 0;
        List suspectedClosestObjects = new ArrayList();
        CollisionInfo closestCollision = null;
        for (i = 0; i < this.collidables.size(); i++) {
            if (trajectory.closestIntersectionToStartOfLine(
                    ((Collidable) (this.collidables.get(i))).getCollisionRectangle()) != null) {
                closestCollision = new CollisionInfo(
                        trajectory.closestIntersectionToStartOfLine(
                                ((Collidable) (this.collidables.get(i))).getCollisionRectangle()),
                        (Collidable) (this.collidables.get(i))
                );
                suspectedClosestObjects.add(closestCollision);
            }
        }
        if (suspectedClosestObjects.isEmpty()) {
            return null;
        }

        Double minimalPoint = trajectory.getStart().distance(
                ((CollisionInfo) (suspectedClosestObjects.get(j))).collisionPoint());
        closestCollision = new CollisionInfo(
                ((CollisionInfo) (suspectedClosestObjects.get(j))).collisionPoint(),
                ((CollisionInfo) (suspectedClosestObjects.get(j))).collisionObject()
        );
        for (j = 1; j < suspectedClosestObjects.size(); j++) {
            if (trajectory.getStart().distance(
                    ((CollisionInfo) (suspectedClosestObjects.get(j))).collisionPoint()) < minimalPoint) {
                minimalPoint = trajectory.getStart().distance(
                        ((CollisionInfo) (suspectedClosestObjects.get(j))).collisionPoint());
                //Save the information about the collidable object. its point and object
                closestCollision = new CollisionInfo(
                        ((CollisionInfo) (suspectedClosestObjects.get(j))).collisionPoint(),
                        ((CollisionInfo) (suspectedClosestObjects.get(j))).collisionObject()
                );
            }
        }
        return closestCollision;
    }

    /** return the list of collidables objects.
     *
     * @return the list of collidables objects
     */
    public java.util.List<Collidable> getCollidables() {
        return this.collidables;
    }

}
