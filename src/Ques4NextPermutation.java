import common.Util;

/**
 * 求数组全排列中某一排列的下一个比他大的排列
 * 考虑：我们从右边的倒数第二个开始，找到第一个比后面的数要小的数，然后再从右边最后一个开始，找到第一个比他大的数，交换这两个，再转置数组
 * 心得：这种交换的题很可能都会有转置。
 * Created by oubin on 17-3-20.
 */
public class Ques4NextPermutation {

    /**
     * 输入下一个比他大的排列
     * @param nums 全排列中的某一排列
     */
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }
        if (i >= 0){
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            Util.swap(nums, i, j);
        }
        Util.reverse(nums,i + 1);
    }
}
