import java.util.Arrays;

/**
 * 此题有两种变式，一种是每个数字只允许出现一次，一种是每个数字只允许出现两次
 * 测试用例：
 * Created by oubin on 17-3-28.
 */
public class Ques17RemoveDuplicateFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;

        int id = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[i - 1]) nums[id++] = nums[i];
        }
        return id;
    }

    /**
     * 试着使用上面的解法。由于有两种可能都需要“压进”。可以对这两种情况分别考虑
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums){
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;

        int id = 1;
        int time = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i - 1] && time < 2){
                nums[id++] = nums[i];
                time++;
            }else if (nums[i] == nums[i - 1] && time >= 2){
                time++;
            }else if (nums[i] != nums[i - 1]){
                nums[id++] = nums[i];
                time = 1;
            }
        }
        return id;
    }

    /**
     * 优化的第二种解法
     * @param nums
     */
    public int removeDuplicatesii(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates2(new int[]{1,1,1,2,2,3,4,5,5,5,5,5}));
        System.out.println(removeDuplicates2(new int[]{1,1,1,1}));
        System.out.println(removeDuplicates2(new int[]{1,1,2,2}));
        System.out.println(removeDuplicates2(new int[]{1}));
        System.out.println(removeDuplicates2(new int[]{1,2,3,4}));
        System.out.println(removeDuplicates2(new int[]{1,2,3,4,4,4}));

    }

}
