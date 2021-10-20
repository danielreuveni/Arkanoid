/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-24-06
 */
/**
 * this interface define hitlistener objects.
 */
public interface HitNotifier {

    /**
     * Add hl as a listener to hit events.
     * @param hl the hitlistener object to game environment.
     */
    void addHitListener(HitListener hl);

    /** Remove hl from the list of listeners to hit events.
     * @param hl  the hitlistener object
     */
    void removeHitListener(HitListener hl);
}