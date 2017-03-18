import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array * which gives the sum of zero.
 * 考虑：用三个指针，先排序，中间指针定位到最小正数，然后前后两个数作为前后指针，如果遇到重复数字就跳过
 * 测试用例：空，长度小于3,全为正数或负数或0.有解，无解。
 *
 * 结果：失败。想法错误
 * Created by oubin on 17-3-18.
 */
public class Ques2ThreeSums {

    /*
    * 想法错误，在只有一个负数和很多正数，或者只有一个正数，很多负数的情况下没有办法建立三个指针。
    * */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // verify the input
        if (nums == null || nums.length < 3) return result;
        // sort is O(nlgn)
        Arrays.sort(nums);
        if (nums[nums.length - 1] < 0 || nums[0] > 0) return result;

        int mid = 0;
        // Step 1: find the min positive number. It is O(n).If all the nums is 0,return a Zero list.
        while(mid < nums.length && nums[mid] <= 0){
            mid++;
        }
        if (mid == nums.length){
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(0);
            list.add(0);
            result.add(list);
            return result;
        }

        // Step 2: begin to find the three nums.
        return null;
    }

    /**
     * 只能采用固定一个再移动另外两个的方法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

}
