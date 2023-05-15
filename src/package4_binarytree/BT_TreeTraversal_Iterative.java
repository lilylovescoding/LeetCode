package package4_binarytree;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BT_TreeTraversal_Iterative {
    //采用stack数据结构 【TC: O(n)  SC: O(h)】
    public void preOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);

        while(!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            System.out.println(cur);
            if(cur.right != null) {
                stack.offerFirst(cur.right);
            }
            if(cur.left != null) {
                stack.offerFirst(cur.left);
            }
        }
    }
    //------------------------------------------------
    //采用stack数据结构和helper函数  【TC: O(n)  SC: O(h)】
    public void inOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode helper = root;

        while(helper != null || !stack.isEmpty()) {
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
    //------------------------------------------------
    //采用两个stack的数据结构 【TC:O(2n)  SC:O(h)】
    public void postOrderTraversal_1(TreeNode root) {
        if(root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<TreeNode> temp = new ArrayDeque<>();
        stack.offerFirst(root);

        while(!stack.isEmpty()) {
           TreeNode cur =  stack.pollFirst();
           temp.offerFirst(cur);
           if(cur.left != null) {
               stack.offerFirst(cur.left);
           }
           if(cur.right != null) {
               stack.offerFirst(cur.right);
           }
        }

        while(!temp.isEmpty()) {
            System.out.println(temp.pollFirst().val);
        }
    }
    //------------------------------------------------
    //创建prev和cur指针，一个stack结构
    public void postOrderTraversal2(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);

        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peekFirst();
            // going down
            if (prev == null || cur == prev.left || cur == prev.right) {
                if (cur.left != null) {
                    stack.offerFirst(cur.left);
                } else if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    result.add(cur.val);
                    stack.pollFirst();
                }
            } else if (prev == cur.left) { // from left subtree
                if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    result.add(cur.val);
                    stack.pollFirst();
                }
            } else { // from right subtree
                result.add(cur.val);
                stack.pollFirst();
            }
            prev = cur;
        }

        // Print the result in reverse order (post-order traversal)
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.println(result.get(i));
        }
    }
}
