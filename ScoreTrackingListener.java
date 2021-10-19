/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-24-06
 */

/**
 * this class defined the counter of the score.
 */
public class ScoreTrackingListener implements HitListener {
    //members
    private Counter currentScore;

    /** constructor.
     *
     * @param scoreCounter the value of the score.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /** this method increase the score in five minutes when some block was hit.
     * @param beingHit the being hit block
     * @param hitter the hitter ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);

    }
}
