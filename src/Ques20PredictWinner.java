/**
 * Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.
 * Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.
 * 考虑：第一种算法用一种非动态规划的解法来模拟真实的博弈过程。   第二种算法使用动态规划
 * Created by oubin on 17-3-31.
 */
public class Ques20PredictWinner {

    public boolean predictTheWinner(int[] nums) {
        return first(nums, 0, nums.length - 1, 0, 0);
    }

    private boolean first(int[] nums, int left, int right, int s1, int s2) {
        if (left > right) {
            return s1 >= s2;
        }
        return !second(nums, left + 1, right, s1 + nums[left], s2) || !second(nums, left, right - 1, s1 + nums[right], s2);
    }


    private boolean second(int[] nums, int left, int right, int s1, int s2) {
        if (left > right) {
            return s1 < s2;
        }
        return !first(nums, left + 1, right, s1, s2 + nums[left]) || !first(nums, left, right - 1, s1, s2 + nums[right]);
    }


    /**
     * 将Player1选择的数作为add，将Player2选择的数作为minus。可以用下面的算式模拟
     * 4-（3-（2-1））：其中4和2都是player1选的，3和1都是player2选的，所以最终等于 4-3+2-1=2。player1赢。
     * @param nums
     * @return
     */
    public boolean predictTheWinner2(int[] nums) {
        return helper(nums, 0, nums.length - 1) >= 0;
    }

    private int helper(int[] nums, int s, int e) {
        return s == e ? nums[e] : Math.max(nums[e] - helper(nums, s, e - 1), nums[s] - helper(nums, s + 1, e));
    }

    // 使用数组保存，可以避免重复计算
    public boolean predictTheWinner3(int[] nums) {
        return helper(nums, 0, nums.length - 1, new Integer[nums.length][nums.length]) >= 0;
    }

    private int helper(int[] nums, int start, int end, Integer[][] cache) {
        if (cache[start][end] == null) {
            cache[start][end] = start == end ?
                    nums[end] :
                    Math.max(nums[end] - helper(nums, start, end - 1, cache), nums[start] - helper(nums, start + 1, end, cache));
        }
        return cache[start][end];
    }
}
