package package4_binarytree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(){

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(7);
        root.left = a;
        root.right = b;
        System.out.println(root.val);
    }
}


