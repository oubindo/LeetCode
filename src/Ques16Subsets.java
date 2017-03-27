import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets. Note: The solution set must not contain duplicate subsets.
 * 考虑：这是一种回溯算法的典型使用。之前做的版本由于到了最后一个元素的时候会重复添加而不能使用。
 * Created by oubin on 17-3-27.
 */
public class Ques16Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        subsetsHelper(nums, list, res, 0);
        return res;
    }


    // FIXME: 17-3-27 这个算法有问题,下面的算法才是正确的。
    private List<List<Integer>> subsetsHelper2(int[] nums, List<Integer> list, List<List<Integer>> res, int curr) {
        if (curr == nums.length) {
            res.add(list);
            return res;
        }
        List<Integer> addList = new ArrayList<>(list);
        addList.add(nums[curr]);
        List<List<Integer>> add = subsetsHelper2(nums, addList, res, curr + 1);
        List<Integer> unAddList = new ArrayList<>(list);
        List<List<Integer>> unAdd = subsetsHelper2(nums, unAddList, res, curr + 1);
        add.addAll(unAdd);
        return add;
    }

    private static void subsetsHelper(int[] nums, List<Integer> list, List<List<Integer>> res, int curr) {
        res.add(new ArrayList<Integer>(list));
        for (int i = curr; i < nums.length; i++){
            list.add(nums[i]);
            subsetsHelper(nums, list, res, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3});
    }

}
