/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-24-06
 */

import biuoop.DrawSurface;

/**
 * this class add to the game block with the score of the game.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;
    /** constructor.
     * @param score the value of the score
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    /** this method draw block with the text "score" to the screen.
     * @param d the drawsurface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(java.awt.Color.WHITE);
        d.fillRectangle(0, 0, 800, 20);
        d.setColor(java.awt.Color.BLACK);
        d.drawText(370, 17, new String("Score: ").concat(String.valueOf(this.score.getValue())) , 17);
    }

    /**
     * timepassed method.
     */
    public void timePassed() {
    }

    /** this method add the score block to the game.
     * @param g the game
     */
    public void addToGame(Game g) {
        g.addSprite((Sprite) (this));
    }
}
