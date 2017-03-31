import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个三角形，求从顶到底的最小的路径和。
 * 考虑：从底向上可以解决从顶向下的边界判断(是否是边界值0或size - 1)，什么时候加入到mini中。
 * Created by oubin on 17-3-30.
 */
public class Ques18Triangle {

    public static int miniTotal(List<List<Integer>> triangle){
        if (triangle == null || triangle.size() == 0) return 0;

        for (int i = triangle.size() - 2; i >= 0; i--){
            for (int j = 0; j <= i; j++){
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }


}
