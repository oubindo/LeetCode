import java.util.Arrays;

/**
 * Created by oubin on 17-3-24.
 */
public class Huawei {



    public static String haha(String seq) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        if (seq == null || seq.equals("")) return Arrays.toString(nums);

        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (c == 'L' || c == 'A') {
                swap(nums, 0, 4);
                swap(nums, 1, 5);
                swap(nums, 4, 5);
            } else if (c == 'R' || c == 'C') {
                swap(nums, 0, 4);
                swap(nums, 1, 5);
                swap(nums, 0, 1);
            } else if (c == 'F') {
                swap(nums, 2, 4);
                swap(nums, 3, 5);
                swap(nums, 5, 6);
            } else if (c == 'B') {
                swap(nums, 2, 4);
                swap(nums, 3, 5);
                swap(nums, 2, 3);
            }
        }
        return Arrays.toString(nums);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        dijkstra(4, new int[]{6}, new int[]{6});
    }


    private static int mEdgNum;        // 边的数量
    private static char[] mVexs = {'1','2','3','4','5','6'};       // 顶点集合
    private static final int MAX = Integer.MAX_VALUE;   // 最大值
    private static int[][] mMatrix = {
            {0, 2, 10, 5, 3, MAX},
            {MAX, 0, 12, MAX, MAX, 10},
            {MAX, MAX, 0, MAX, 7, MAX},
            {2, MAX, MAX, 0, 2, MAX},
            {4, MAX, MAX, 1, 0, MAX},
            {3, MAX, 1, MAX, 2, 0}};    // 邻接矩阵


    public static void dijkstra(int vs, int[] prev, int[] dist) {
        // flag[i]=true表示"顶点vs"到"顶点i"的最短路径已成功获取
        boolean[] flag = new boolean[mVexs.length];

        // 初始化
        for (int i = 0; i < mVexs.length; i++) {
            flag[i] = false;          // 顶点i的最短路径还没获取到。
            prev[i] = 0;              // 顶点i的前驱顶点为0。
            dist[i] = mMatrix[vs][i];  // 顶点i的最短路径为"顶点vs"到"顶点i"的权。
        }

        // 对"顶点vs"自身进行初始化
        flag[vs] = true;
        dist[vs] = 0;

        // 遍历mVexs.length-1次；每次找出一个顶点的最短路径。
        int k=0;
        for (int i = 1; i < mVexs.length; i++) {
            // 寻找当前最小的路径；
            // 即，在未获取最短路径的顶点中，找到离vs最近的顶点(k)。
            int min = MAX;
            for (int j = 0; j < mVexs.length; j++) {
                if (flag[j]==false && dist[j]<min) {
                    min = dist[j];
                    k = j;
                }
            }
            // 标记"顶点k"为已经获取到最短路径
            flag[k] = true;

            // 修正当前最短路径和前驱顶点
            // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
            for (int j = 0; j < mVexs.length; j++) {
                int tmp = (mMatrix[k][j]== MAX ? MAX : (min + mMatrix[k][j]));
                if (flag[j]==false && (tmp<dist[j]) ) {
                    dist[j] = tmp;
                    prev[j] = k;
                }
            }
        }

        // 打印dijkstra最短路径的结果
        System.out.printf("dijkstra(%c): \n", mVexs[vs]);
        for (int i=0; i < mVexs.length; i++)
            System.out.printf("  shortest(%c, %c)=%d\n", mVexs[vs], mVexs[i], dist[i]);
    }


 }
