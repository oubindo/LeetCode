import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 求树的最小深度，之前用递归法做过这个题，现在用非递归法来做这个题。
 * Created by oubin on 17-3-23.
 */
public class Ques11TreeMinDepth {

    public static int minDepth(TreeNode root){
        if (root == null) return 0;

        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 1;
        while (!queue.isEmpty()){
            List<TreeNode> temp = new ArrayList<>();
            for (TreeNode node : queue){
                if (node.left == null && node.right == null) return height;
                if (node.left != null) temp.add(node.left);
                if (node.right != null) temp.add(node.right);
            }
            height++;
            queue = temp;
        }
        return height;
    }

}
