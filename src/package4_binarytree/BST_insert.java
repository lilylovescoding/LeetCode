package package4_binarytree;

public class BST_insert {
    //1. Recursive    TC:O(h) SC:O(h)
    public TreeNode insert1(TreeNode root, int target) {
        if( root == null) {
            return new TreeNode(target);
        }

        if(root.val < target) {
            root.right = insert1(root.right, target);
        } else if (root.val > target) {
            root.left = insert1(root.left, target);
        }
        return root;
    }

    //2. Iterative-1   TC:O(h) SC:O(1)



    //3. Iterative-2   TC:O(h) SC:O(1)

    
}
