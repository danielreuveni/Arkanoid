/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-05-08
 */

/**.
this class sets off the game
 */
public class Ass5Game {
    /**this method called the game method from the main.
     *
     * @param args nothing
     */
    public static void main(String[] args) {
        game();
    }

    /** this method initalize and run the game.
     *
     */
    public static void game() {
        Game game = new Game();
        game.initialize();
        game.run();
    }

}
