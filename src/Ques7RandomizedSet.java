import java.util.*;

/**
 * 实现一个数据结构，使得插入，删除，getRandom都是O(1)的复杂度
 * 考虑：如果是链表，插入，删除是o1,如果是数组，插入，随机是o1，删除不是。
 * Created by oubin on 17-3-21.
 */
public class Ques7RandomizedSet {

    List<Integer> list;
    Map<Integer,Integer> map;
    Random rand;

    /** Initialize your data structure here. */
    public Ques7RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int index = map.get(val);
        if (index < list.size() - 1){
            int last = list.get(list.size() - 1);
            list.set(index, last);
            map.put(last, index);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
