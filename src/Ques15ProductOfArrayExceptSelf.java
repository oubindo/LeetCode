import java.util.Arrays;

/**
 * 给出一个数组，用O(n) time 和 O(1) space来求目标数组，使得每一个元素是原数组中其他元素的乘积
 * 考虑：曾经想先算出所有的乘积再一个一个去除，但是这方法只要数组中有0,就不适用。
 * 测试用例：数组有0,数组有负数，正常数组，空数组。
 * Created by oubin on 17-3-27.
 */
public class Ques15ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums){
        if (nums  == null || nums.length == 0){
            return nums;
        }
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++){
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int j = nums.length - 1; j >= 0; j--){
            res[j] *= right;
            right *= nums[j];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{0, 2, 3, 4})));
    }

}
