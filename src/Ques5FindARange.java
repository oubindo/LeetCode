/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 考虑：这题很显然用binary search做，返回一个数组。先用二分查找找到最左边的数，再找到最右边的数。
 * Created by oubin on 17-3-20.
 */
public class Ques5FindARange {

    private static int getFirstK(int[] data, int k, int start, int end) {
        if (data == null || data.length < 1 || start > end) {
            return -1;
        }
        int midIdx = start + (end - start) / 2;
        int midData = data[midIdx];
        if (midData == k) {
            if (midIdx > 0 && data[midIdx - 1] != k || midIdx == 0) {
                return midIdx;
            } else {
                end = midIdx - 1;
            }
        } else if (midData > k) {
            end = midIdx - 1;
        } else {
            start = midIdx + 1;
        }
        return getFirstK(data, k, start, end);
    }
    /**
     * 找排序数组中k最后一次出现的位置
     *
     * @param data
     * @param k
     * @param start
     * @param end
     * @return
     */
    private static int getLastK(int[] data, int k, int start, int end) {
        if (data == null || data.length < 1 || start > end) {
            return -1;
        }
        int midIdx = start + (end - start) / 2;
        int midData = data[midIdx];
        if (midData == k) {
            if (midIdx + 1 < data.length && data[midIdx + 1] != k || midIdx == data.length - 1) {
                return midIdx;
            } else {
                start = midIdx + 1;
            }
        } else if (midData < k) {
            start = midIdx + 1;
        } else {
            end = midIdx - 1;
        }
        return getLastK(data, k, start, end);
    }
    /**
     * 题目：统计一个数字：在排序数组中出现的次数
     * @param nums
     * @param k
     * @return
     */
    public static int[] searchRange(int[] nums, int k) {
        int[] result = new int[]{-1, -1};
        if (nums != null && nums.length > 0) {
            int first = getFirstK(nums, k, 0, nums.length - 1);
            int last = getLastK(nums, k, 0, nums.length - 1);
            result[0] = first;
            result[1] = last;
        }
        return result;
    }


}
