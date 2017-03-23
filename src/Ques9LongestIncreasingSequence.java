/**
 * 数组最长递增子序列
 * Created by oubin on 17-3-22.
 */
public class Ques9LongestIncreasingSequence {

    public static int longestSeqDP(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] lens = new int[nums.length];
        int length = 1;
        for (int i = 0; i < nums.length; i++) {
            lens[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[j] && lens[j] + 1 > lens[i]) {
                    lens[i] = lens[j] + 1;
                }
            }
            if (lens[i] > length) length = lens[i];
        }
        return length;
    }

    // https://www.felix021.com/blog/read.php?1587
    // 主要是通过一个数组，记录下对应长度LIS的最小末尾。有了这个末尾，我们就可以一个一个的插入数据
    /*
    * 首页 登入 RSS 注册 留言 链接 归档 关于
XeTeX模板 Ubuntu 9.04入门小结
MAY
13
最长递增子序列 O(NlogN)算法  不指定
felix021 @ 2009-5-13 04:15 , IT » 程序设计 , 评论(39) , 引用(0) , 阅读(60080) , Via 本站原创  大 | 中 | 小
今天回顾WOJ1398，发现了这个当时没有理解透彻的算法。
看了好久好久，现在终于想明白了。
试着把它写下来，让自己更明白。

最长递增子序列，Longest Increasing Subsequence 下面我们简记为 LIS。
排序+LCS算法 以及 DP算法就忽略了，这两个太容易理解了。

假设存在一个序列d[1..9] = 2 1 5 3 6 4 8 9 7，可以看出来它的LIS长度为5。
下面一步一步试着找出它。
我们定义一个序列B，然后令 i = 1 to 9 逐个考察这个序列。
此外，我们用一个变量Len来记录现在最长算到多少了

首先，把d[1]有序地放到B里，令B[1] = 2，就是说当只有1一个数字2的时候，长度为1的LIS的最小末尾是2。这时Len=1

然后，把d[2]有序地放到B里，令B[1] = 1，就是说长度为1的LIS的最小末尾是1，d[1]=2已经没用了，很容易理解吧。这时Len=1

接着，d[3] = 5，d[3]>B[1]，所以令B[1+1]=B[2]=d[3]=5，就是说长度为2的LIS的最小末尾是5，很容易理解吧。这时候B[1..2] = 1, 5，Len＝2

再来，d[4] = 3，它正好加在1,5之间，放在1的位置显然不合适，因为1小于3，长度为1的LIS最小末尾应该是1，这样很容易推知，长度为2的LIS最小末尾是3，于是可以把5淘汰掉，这时候B[1..2] = 1, 3，Len = 2

继续，d[5] = 6，它在3后面，因为B[2] = 3, 而6在3后面，于是很容易可以推知B[3] = 6, 这时B[1..3] = 1, 3, 6，还是很容易理解吧？ Len = 3 了噢。

第6个, d[6] = 4，你看它在3和6之间，于是我们就可以把6替换掉，得到B[3] = 4。B[1..3] = 1, 3, 4， Len继续等于3

第7个, d[7] = 8，它很大，比4大，嗯。于是B[4] = 8。Len变成4了

第8个, d[8] = 9，得到B[5] = 9，嗯。Len继续增大，到5了。

最后一个, d[9] = 7，它在B[3] = 4和B[4] = 8之间，所以我们知道，最新的B[4] =7，B[1..5] = 1, 3, 4, 7, 9，Len = 5。

于是我们知道了LIS的长度为5。
    * */

    public static int longestSeqNlgN(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int i = 0, len = 1;
        int[] end = new int[nums.length + 1];
        end[1] = nums[0];
        for (i = 1; i < nums.length; i++) {
            int pos = upper_bound(end, 1, len, nums[i]); //找到插入位置
            end[pos] = nums[i];
            if (len < pos) //按需要更新LIS长度
                len = pos;
        }
        return len;
    }

    public static int upper_bound(int arr[], int s, int e, int key) {
        int mid;
        if (arr[e] <= key)
            return e + 1;
        while (s < e) {
            mid = s + (e - s) / 2;
            if (arr[mid] <= key)
                s = mid + 1;
            else
                e = mid;
        }
        return s;
    }

}
