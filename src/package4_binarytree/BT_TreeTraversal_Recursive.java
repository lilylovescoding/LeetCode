package package4_binarytree;

import java.util.ArrayList;
import java.util.List;

public class BT_TreeTraversal_Recursive {

    public void preOrderTraversal(TreeNode root) {
        if(root == null) {
            return ;
        }
        System.out.println(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal(TreeNode root) {
        if(root == null) {
            return ;
        }
        inOrderTraversal(root.left);
        System.out.println(root);
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(TreeNode root) {
        if(root == null) {
            return ;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root);
    }

    //inorder顺序返回list
    public List<Integer> inOrderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

}
