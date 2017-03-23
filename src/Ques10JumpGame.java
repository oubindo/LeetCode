/**
 * Jump Game：Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * 考虑：这个题使用贪心算法。贪心算法的本质就是每一步的最优解一定取决于前一步的最优解。所以我们可以构造子问题 d(j) = max(d(j - 1) - 1, nums[j]);
 * Created by oubin on 17-3-23.
 */
public class Ques10JumpGame {

    // 这个算法虽然可以使用，但是会出现Time limit。
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true;

        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr = Math.max(curr - 1, nums[i]);
            if (curr <= 0) return false;
        }
        return true;
    }

    public static boolean canJumpGreedy(int[] A) {
        int n = A.length;
        int last = n - 1, i, j;
        for (i = n - 2; i >= 0; i--) {
            if (i + A[i] >= last) last = i;
        }
        return last <= 0;
    }
}
