package package4_binarytree;

public class Pre_In_PostOrder {

    private int val;
    TreeNode left;
    TreeNode root;
    TreeNode right;

    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        preOrder(root.left);
        System.out.println(root);
        preOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root);
    }



//    public static void main(String[] args) {
//        Pre_In_PostOrder s = new Pre_In_PostOrder();
//        TreeNode root = new TreeNode(4);
//        TreeNode node1 = new TreeNode(10);
//        TreeNode node2 = new TreeNode(5);
//
//        root.left = node1;
//        root.right = node2;
//    }
}
