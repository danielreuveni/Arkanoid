/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-24-06
 */
/** this interface define hitlistener objects.
 */
public interface HitListener {

     /**This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit the block will be hit
     * @param hitter the hitter ball
     */
    void hitEvent(Block beingHit, Ball hitter);
}