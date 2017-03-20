/**
 * Created by oubin on 17-3-19.
 */
public class Ques3ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int minsum = Integer.MIN_VALUE, maxsum = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1, k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > target){
                    maxsum = maxsum < sum ? maxsum : sum;
                }else if(sum == target){
                    return target;
                }else{
                    minsum = minsum > sum ? minsum : sum;
                }
                j++;
                k--;
            }
        }
        if(Math.abs(target - minsum) > Math.abs(maxsum - target)) return maxsum;
        else return minsum;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0, 1, 2, 5}, 5));
    }

}
