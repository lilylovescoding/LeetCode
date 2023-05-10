package package4_binarytree;

public class BT_HeightOfBinaryTree {
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
}
