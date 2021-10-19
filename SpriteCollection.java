/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-05-08
 */

import biuoop.DrawSurface;

import java.util.ArrayList;

/** this class save a collection of sprite objects.
 *
 * */
public class SpriteCollection {
    private java.util.List<Sprite> sprites;

    /** this is a constructor of Sprite Collection.
     *
     * */
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }

    /** this method add the sprite object to the collection.
     * @param s the sprite object
     * */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /** this method remove the sprite object from the game.
     * @param s the sprite object.
     */
    public void deleteSprite(Sprite s) {
        this.sprites.remove(s);
    }


    /** this method call the method of timePassed for all the objects in the collection.
     *
     * */
    public void notifyAllTimePassed() {
        for (int i = 0; i < this.sprites.size(); i++) {
            ((Sprite) (this.sprites.get(i))).timePassed();
        }
    }

    /** this method call drawOn(d) on all sprites.
     * @param d the surface
     * */
        public void drawAllOn(DrawSurface d) {
            for (int i = 0; i < this.sprites.size(); i++) {
                ((Sprite) (this.sprites.get(i))).drawOn(d);
            }
        }


}