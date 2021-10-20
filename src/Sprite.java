/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-05-08
 */

import biuoop.DrawSurface;

/**
 * this interface sets method for sprite objects.
 */
public interface Sprite {
    /** this method draw the sprite objects to the screen.
     *
     * @param d surface
     */
    void drawOn(DrawSurface d);
    /** this method notify the sprites that time has passed.
     *
     */
    void timePassed();
}