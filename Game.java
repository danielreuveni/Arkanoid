/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-06-24
 */

import biuoop.KeyboardSensor;
import biuoop.DrawSurface;
import biuoop.GUI;
import java.awt.Color;
import biuoop.Sleeper;

/** this class run and initialize the game.
 *
 */
public class Game {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter counterBlocks;
    private Counter counterBalls;
    private Counter score;
    private ScoreIndicator scoreIndicator;

    /** consructor of the game, that intialize collection of sprite objects.
     * and the game environment of the game
     *
     */
    public Game() {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.counterBlocks = new Counter(0);
        this.counterBalls = new Counter(3);
        this.score = new Counter(0);
        this.scoreIndicator = new ScoreIndicator(score);
    }

    /** this method get the number hitted blocks in the game.
     * @return the number hitted blocks in the game
     */
    public Counter getCounterBlocks() {
        return this.counterBlocks;
    }

    /** set the value to the counter of the blocks.
     * @param temp the value
     */
    public void setCounterBlocks(Counter temp) {
        this.counterBlocks = temp;
    }
    /** this method add the collidable object to the environment of the game.
     *
     * @param c the collidable object
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**this method add the sprite object to the environment of the game.
     *
     * @param s the sprite object
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);

    }

    /** this method remove the collidable object from the game environment.
     * @param c the coliidable object
     */
    public void removeCollidable(Collidable c) {
        this.environment.deleteCollidable(c);
    }

    /** this method remove the sprite object from the game environment.
     * @param s the sprite object
     */
    public void removeSprite(Sprite s) {
        this.sprites.deleteSprite(s);
    }

    /** this method initialize a new game: create the Blocks and Ball and Paddle.
     // and add them to the game.
     *
     */
    public void initialize() {
        gui = new GUI("Game", 800, 600);
        DrawSurface d = gui.getDrawSurface();
        KeyboardSensor keyboard = this.gui.getKeyboardSensor();
        Ball ball = new Ball(550, 550, 10, Color.white);
        Ball ball2 = new Ball(450, 450, 10, Color.orange);
        Ball ball3 = new Ball(500, 500, 10, Color.magenta);
        GameEnvironment gameEnvironment = new GameEnvironment();
        ball.setGameEnviroment(gameEnvironment);
        ball2.setGameEnviroment(gameEnvironment);
        ball3.setGameEnviroment(gameEnvironment);
        BlockRemover br = new BlockRemover(this, this.counterBlocks);
        BallRemover ballRemover = new BallRemover(this, this.counterBalls);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
        this.scoreIndicator.addToGame(this);

        // add block in a variety of colors
        for (int i = 0; i < 13; i++) {
            Rectangle rectangle = new Rectangle((new Point(720 - 50 * i - 1, 150)), 50, 30);
            Block block1 = new Block(rectangle, Color.gray);
            this.sprites.addSprite(block1);
            ball.getGameEnvironment().addCollidable(block1);
            //ball2.getGameEnvironment().addCollidable(block1);
            //ball3.getGameEnvironment().addCollidable(block1);
            PrintingHitListener p = new PrintingHitListener();
            block1.addHitListener(p);
            block1.addHitListener(br);
            block1.addHitListener(scoreTrackingListener);
        }
        for (int i = 0; i < 12; i++) {
            Rectangle rectangle = new Rectangle((new Point(720 - 50 * i - 1, 180)), 50, 30);
            Block block1 = new Block(rectangle, Color.red);
            this.sprites.addSprite(block1);
            ball.getGameEnvironment().addCollidable(block1);
            //ball2.getGameEnvironment().addCollidable(block1);
            //ball3.getGameEnvironment().addCollidable(block1);
            PrintingHitListener p = new PrintingHitListener();
            block1.addHitListener(p);
            block1.addHitListener(br);
            block1.addHitListener(scoreTrackingListener);
        }
        for (int i = 0; i < 11; i++) {
            Rectangle rectangle = new Rectangle((new Point(720 - 50 * i - 1, 210)), 50, 30);
            Block block1 = new Block(rectangle, Color.yellow);
            block1.addToGame(this);
            ball.getGameEnvironment().addCollidable(block1);
            //ball2.getGameEnvironment().addCollidable(block1);
            //ball3.getGameEnvironment().addCollidable(block1);
            PrintingHitListener p = new PrintingHitListener();
            block1.addHitListener(p);
            block1.addHitListener(br);
            block1.addHitListener(scoreTrackingListener);
        }
        for (int i = 0; i < 10; i++) {
            Rectangle rectangle = new Rectangle((new Point(720 - 50 * i - 1, 240)), 50, 30);
            Block block1 = new Block(rectangle, Color.blue);
            block1.addToGame(this);
            ball.getGameEnvironment().addCollidable(block1);
            //ball2.getGameEnvironment().addCollidable(block1);
            //ball3.getGameEnvironment().addCollidable(block1);
            PrintingHitListener p = new PrintingHitListener();
            block1.addHitListener(p);
            block1.addHitListener(br);
            block1.addHitListener(scoreTrackingListener);
        }
        for (int i = 0; i < 9; i++) {
            Rectangle rectangle = new Rectangle((new Point(720 - 50 * i - 1, 270)), 50, 30);
            Block block1 = new Block(rectangle, Color.pink);
            block1.addToGame(this);
            ball.getGameEnvironment().addCollidable(block1);
            //ball2.getGameEnvironment().addCollidable(block1);
            //ball3.getGameEnvironment().addCollidable(block1);
            PrintingHitListener p = new PrintingHitListener();
            block1.addHitListener(p);
            block1.addHitListener(br);
            block1.addHitListener(scoreTrackingListener);

        }
        for (int i = 0; i < 8; i++) {
            Rectangle rectangle = new Rectangle((new Point(720 - 50 * i - 1, 300)), 50, 30);
            Block block1 = new Block(rectangle, Color.green);
            block1.addToGame(this);
            ball.getGameEnvironment().addCollidable(block1);
            //ball2.getGameEnvironment().addCollidable(block1);
            //ball3.getGameEnvironment().addCollidable(block1);
            PrintingHitListener p = new PrintingHitListener();
            block1.addHitListener(p);
            block1.addHitListener(br);
            block1.addHitListener(scoreTrackingListener);

        }
        Rectangle rectangle1 = new Rectangle((new Point(0, 17)), 800, 13);
        Block block1 = new Block(rectangle1, Color.gray);
        block1.addToGame(this);
        Rectangle rectangle2 = new Rectangle((new Point(0, 30)), 30, 600);
        Block block2 = new Block(rectangle2, Color.gray);
        block2.addToGame(this);
        Rectangle rectangle3 = new Rectangle((new Point(770, 30)), 30, 570);
        Block block3 = new Block(rectangle3, Color.gray);
        block3.addToGame(this);
        Rectangle rectangle4 = new Rectangle((new Point(30, 570)), 740, 30);
        Block block4 = new Block(rectangle4, Color.blue);
        block4.addToGame(this);
        block4.addHitListener(ballRemover);
        Paddle paddle = new Paddle(keyboard);
        paddle.addToGame(this);
        ball.getGameEnvironment().addCollidable(paddle);
        ball.getGameEnvironment().addCollidable(block1);
        ball.getGameEnvironment().addCollidable(block2);
        ball.getGameEnvironment().addCollidable(block3);
        ball.getGameEnvironment().addCollidable(block4);
        ball2.getGameEnvironment().addCollidable(paddle);
        ball2.getGameEnvironment().addCollidable(block1);
        ball2.getGameEnvironment().addCollidable(block2);
        ball2.getGameEnvironment().addCollidable(block3);
        ball2.getGameEnvironment().addCollidable(block4);
        ball3.getGameEnvironment().addCollidable(paddle);
        ball3.getGameEnvironment().addCollidable(block1);
        ball3.getGameEnvironment().addCollidable(block2);
        ball3.getGameEnvironment().addCollidable(block3);
        ball3.getGameEnvironment().addCollidable(block4);
        double speed = 5;
        double angle = 120;
        Velocity v = Velocity.fromAngleAndSpeed(angle, speed);
        ball.setVelocity(v);
        ball2.setVelocity(v);
        ball3.setVelocity(v);
        ball.addToGame(this);
        ball2.addToGame(this);
        ball3.addToGame(this);
    }

    /** this method run the game and start the animation loop.
     *
     */
    public void run() {
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        Sleeper sleeper = new Sleeper();

        while (true) {
            long startTime = System.currentTimeMillis(); // timing

            DrawSurface d = gui.getDrawSurface();
            d.setColor(Color.blue);
            d.fillRectangle(0, 0, 800, 600);
            this.sprites.drawAllOn(d);
            gui.show(d);
            this.sprites.notifyAllTimePassed();
            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
            if (this.counterBlocks.getValue() == 63 || this.counterBalls.getValue() == 0) {
                this.score.increase(100);
                gui.close();
            }

        }
    }
}