/**
 * Resizeable array class, makes a resizable array
 * <p>
 * Aryan Tayal
 * ResizableArray
 */
public class ResizeableArray {
    private Object[] nums;
    private int count;

    /**
     * creates the initial array
     */
    public ResizeableArray() {
        nums = new Object[10];
        count = 0;
    }

    /**
     * @param x - object is imputed
     */
    public void add(Object x) {
        //resize
        if (count == nums.length) {
            Object[] temp = new Object[nums.length * 2];
            for (int i = 0; i < count; i++) {
                temp[i] = nums[i];
            }
            nums = temp;
        }
        nums[count] = x;
        count++;
    }

    /**
     * @return the count
     */
    public int size() {
        return count;
    }

    /**
     * @param pos - position
     * @return - position of the array
     */
    public Object elemAt(int pos) {
        return nums[pos];
    }

}