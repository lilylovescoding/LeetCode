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
    public TreeNode insert2(TreeNode root, int target) {
        if(root == null) {
            return new TreeNode(target);
        }

        TreeNode cur = root;
        while(cur != null && cur.val != target) {
            if(cur.val > target) {
                if(cur.left != null) {
                    cur = cur.left;
                } else {
                    cur.left = new TreeNode(target);
                    break;
                }
            } else {
                if(cur.right != null) {
                    cur = cur.right;
                } else {
                  cur.right = new TreeNode(target);
                  break;
                }
            }
        }
        return root;
    }


    //3. Iterative-2   TC:O(h) SC:O(1)
    public TreeNode insert3(TreeNode root, int target) {
        if(root == null) {
            return new TreeNode(target);
        }

        TreeNode cur = root;
        TreeNode pre = null;

        while(cur != null) {
            pre = cur;
            if(cur.val < target) {
                cur = cur.right;
            } else if (cur.val > target) {
                cur = cur.left;
            } else {
                return root;
            }
        }

        if(pre.val < target) {
            pre.right = new TreeNode(target);
        } else if (pre.val > target) {
            pre.left = new TreeNode(target);
        }
        return root;
    }
    
}
