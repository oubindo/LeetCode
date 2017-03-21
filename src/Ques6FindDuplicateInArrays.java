import java.util.ArrayList;
import java.util.List;

/**
 * 寻找数组中的重复数字。如果可以用额外空间，肯定用HashMap，如果不能用，必须在数组上进行记录时，可以采用取反的方法记录下已经被遍历过和没有被遍历过的数字。
 * Created by oubin on 17-3-21.
 */
public class Ques6FindDuplicateInArrays {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(i) - 1;
            if(nums[index] < 0)
                result.add(Math.abs(index + 1));
            nums[index] = -nums[index];
        }
        return result;
    }
}
