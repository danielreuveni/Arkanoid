/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-24-06
 */

/** this class notify when block is hit.
 */
public class PrintingHitListener implements HitListener {
    /** print message when block was hit.
     * @param beingHit the neinghit block
     * @param hitter the hitter ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Block was hit.");
    }
}