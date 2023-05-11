package package4_binarytree;

public class BT_CountNodes {
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
}
