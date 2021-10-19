/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-24-06
 */

// a BlockRemover is in charge of removing blocks from the game, as well as keeping count
// of the number of blocks that remain.

/**
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    //members
    private Game game;
    private Counter removedBlocks;

    /** constructor.
     *
     * @param game the game
     * @param removedBlocks the counter of the blocks
     */
    public BlockRemover(Game game, Counter removedBlocks) {
        this.game = game;
        this.removedBlocks = removedBlocks;
    }

    // Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.

    /**Blocks that are hit should be removed
     * from the game. Remember to remove this listener from the block
     * that is being removed from the game.
     *
     * @param beingHit the block will be hit
     * @param hitter the ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getNumberOfHits() == 0) {
            beingHit.removeFromGame(this.game);
            beingHit.removeHitListener(this);
            //hitter.getGameEnvironment().removeCollidable(beingHit);
            this.removedBlocks.increase(1);
            this.game.setCounterBlocks(this.removedBlocks);

        }
    }
}