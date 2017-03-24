import common.Interval;

import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * Created by oubin on 17-3-24.
 */
public class Ques12MergeIntervals {

    /**
     * 这种算法是比较慢的，虽然也是O（nlgn）。但是增加了很多删除和添加元素的操作，显得比较慢。
     * @param intervals
     * @return
     */
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };
        Collections.sort(intervals, comparator);
        int i = 0;
        while (i < intervals.size() - 1){
            Interval curr = intervals.get(i);
            Interval next = intervals.get(i + 1);
            if (curr.end < next.start){
                i++;
            }else{
                Interval merge;
                if (curr.end < next.end){
                    merge = new Interval(curr.start, next.end);
                }else{
                    merge = new Interval(curr.start, curr.end);
                }
                intervals.remove(i);
                intervals.remove(i);
                intervals.add(i, merge);
            }
        }
        return intervals;
    }


    /**
     * 这种算法通过不断的移动end和start来处理，比上面两两相比再删除添加更好一些。
     * @param intervals
     * @return
     */
    public static List<Interval> merge2(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }

    public static void main(String[] args) {
        Interval v1 = new Interval(1, 3);
        Interval v2 = new Interval(2, 5);
        Interval v3 = new Interval(6, 8);
        Interval v4 = new Interval(9, 13);
        Interval v5 = new Interval(12, 16);
        List<Interval> list = new ArrayList<>();
        list.add(v5);
        list.add(v3);
        list.add(v1);
        list.add(v2);
        list.add(v4);
        merge(list);
    }

}
