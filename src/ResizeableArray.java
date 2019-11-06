import java.util.*;

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
            Object[] temp = new Object[nums.length*2];
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

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(nums[i].toString() + "\n");
        }
        return result.toString();
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(nums[i]);
        }
    }

}