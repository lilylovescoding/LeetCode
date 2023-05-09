package package4_binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

public class InOrderTree_Iterative {

    public void inOrder(TreeNode root) {
        //initial check
        if(root == null) {
            return;
        }
        //创建stack和helper node
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode helper = root;

        while (helper != null || !stack.isEmpty()) {
            if(helper != null) {
                stack.offerFirst(helper);
                helper = helper.left;
            } else {
                helper = stack.pollFirst();
                System.out.println(helper.val);
                helper = helper.right;
            }
        }
    }
}
