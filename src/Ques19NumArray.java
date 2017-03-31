/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.但是要注意到这里的sumRange是
 * 要被多次调用的，所以需要注意调用时间复杂度，一般通过别的时期的操作来转移复杂度。
 * Created by oubin on 17-3-31.
 */
public class Ques19NumArray {

    int[] array;

    public Ques19NumArray(int[] nums) {
        for (int i = 1; i < nums.length; i++){
            nums[i] = nums[i - 1] + nums[i];
        }
        this.array = nums;
    }

    public int sumRange(int i, int j) {
        if (i == 0) return array[j];

        return array[j] - array[i - 1];
    }

}
