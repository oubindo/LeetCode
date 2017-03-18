/**
 * 题目描述：Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines * are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a * container, such that the container contains the most water.
 * 考虑：数组问题一般可以考虑双指针
 * 心得：双指针问题最重要的是要考虑怎么样才能移动指针，最好是能造成结果向一个方向发展的。
 * Created by oubin on 17-3-17.
 */
public class Ques1ContainerWithMostSpace {

    public int maxArea(int[] height){
        if (height == null || height.length <= 1) return 0;

        int first = 0, second = height.length - 1;
        int max = 0;
        while (first < second){
            int area = computerArea(height, first, second);
            max = max > area ? max : area;
            if (height[first] <= height[second]) first++;
            else second--;
        }
        return max;
    }

    private int computerArea(int[] height, int first, int second) {
        int min = height[first] < height[second] ? height[first] : height[second];
        return (second - first) * min;
    }


}
