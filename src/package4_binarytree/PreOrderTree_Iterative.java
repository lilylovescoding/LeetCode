package package4_binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

public class PreOrderTree_Iterative {
    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.offerFirst(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            System.out.println(cur.val);
            if(cur.right != null) {
                stack.offerFirst(cur.right);           //stack是FILO，所以要先放右边的node
            }
            if(cur.left != null) {
                stack.offerFirst(cur.left);
            }
        }
    }
}
