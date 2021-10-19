/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-24-06
 */

/** this class responsible to remove the ball from the game.
 */

public class BallRemover implements HitListener {
    //membres
    private Game game;
    private Counter balls;

    /** this method is the constructor of the class.
     *
     * @param game the game
     * @param removedBalls the counter of the removed balls
     */
    public BallRemover(Game game, Counter removedBalls) {
        this.game = game;
        this.balls = removedBalls;
    }

    /** remove the specific ball from the game.
     *
     * @param beingHit the block will be hit
     * @param hitter the hitter ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.balls.decrease(1);
    }
}
