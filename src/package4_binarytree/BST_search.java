package package4_binarytree;

public class BST_search {

    //1. Recursive  TC:O(h) SC:O(h)
    public TreeNode search(TreeNode root, int target) {
        if (root == null || root.val == target) {
            return root;
        }
        if (target < root.val) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }

    //2.Iterative  TC:O(h)  SC:O(1)
    public TreeNode search2(TreeNode root, int target) {
        while(root != null && root.val != target) {
            if(target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }

}


