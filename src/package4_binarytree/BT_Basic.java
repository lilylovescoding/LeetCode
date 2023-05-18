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


    //5.判断二叉树是否identical、twist identical


    //6.判断是否为binary search tree
}
