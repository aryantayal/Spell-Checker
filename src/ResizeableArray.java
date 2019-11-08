public class ResizeableArray {
    private Object[] nums;
    private int count;

    public ResizeableArray() {
        nums = new Object[10];
        count = 0;
    }

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

    public int size() {
        return count;
    }

    public Object elemAt(int pos) {
        return nums[pos];
    }



}