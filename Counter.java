/** * @author <Daniel Reuveni><drdrdrq@gmail.com>
 ID: <207982869>
 * @version 1
 * @since 2020-24-06
 */

/**
 * this class is define type of counter.
 */
public class Counter {
    //members
    private int val = 0;

    /**
     * constructor.
     * @param valTemp the value
     */
    public Counter(int valTemp) {
        this.val = valTemp;
    }

    // add number to current count.

    /** this method add number to current count.
     * @param number the number
     */
    void increase(int number) {
        this.val = this.val + number;
    }

    /** this method subtract number from current count.
     * @param number the number
     */
    void decrease(int number) {
        this.val = this.val - number;
    }

    /** this method get the current count.
     * @return the current count.
     */
    int getValue() {
        return this.val;
    }
}