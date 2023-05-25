package package4_binarytree;

public class BT_Basic {

    //1.二叉树的高度  < TC:O(n) SC:O(height) >
    public int getHeight(TreeNode root){
        //base case
        if(root==null){
            return 0;
        }
        //left height, right height
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight)+1;
    }

    //2.二叉树的节点数  < TC:O(n) SC:O(n) >
    public int countNodes(TreeNode root){
        //base case
        if(root==null){
            return 0;
        }
        //left count, right count
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return leftCount + rightCount + 1;
    }

    //3.判断二叉树是否是Balanced  <TC:O(nlogn)  SC:O(height)>
    public boolean isBalanced(TreeNode root) {
        //base case
        if(root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    //4.判断二叉树是否symmetric
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        } else if(left == null || right = null) {
            return false;
        } else if(left.val != right.val){
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    //5.判断二叉树是否identical、twist identical
    public boolean isIdentical(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        } else if(left == null || right = null) {
            return false;
        } else if(left.val != right.val){
            return false;
        }
        // 对称 || 完全一样
        return (isIdentical(left.left, right.right) && isIdentical(left.right, right.left)) || (isIdentical(left.left, right.left) && isIdentical(left.right, right.right));
    }

    //6.判断是否为binary search tree  TC:O(n) SC:O(height)
    public boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

    // 7. 在给定范围内打印BST的值   TC:O(n)  SC:O(height)
    public void printBSTInRange(TreeNode root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.val < k1) {
            printBSTInRange(root.right, k1, k2);
        }
        if (root.val >= k1 && root.val <= k2) {
            printBSTInRange(root.val);
        }
        if (root.val > k2) {
            printBSTInRange(root.left, k1, k2);
        }
    }

}
