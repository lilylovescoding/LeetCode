//package package4_binarytree;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//// 【序列化和反序列化二叉搜索树】
//// 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
//// 设计一个算法来序列化和反序列化 二叉搜索树。对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树
//// 编码的字符串应尽可能紧凑
//// root = [2,1,3]  => [2,1,3]
//// root = []  => []
//public class Leetcode449 {
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        if(root == null) {
//            return "#";
//        }
//        List<Integer> list = new ArrayList<>();
//        preOrder(root, list);
//        return String.valueOf(list);
//    }
//
//// Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        String[] str = data.split(",");
//        List<String> str2 = Arrays.asList(str);
//        List<String> arr = new ArrayList<>(str2);
//        return redeser(arr);
//    }
//
//    public void preOrder(TreeNode root, List<Integer> list) {
//        if(root == null){
//            return;
//        }
//        list.add(root.val);
//        preOrder(root.left, list);
//        preOrder(root.right, list);
//
//    }
//
//    public TreeNode redeser(List<String> arr) {
//        if(arr.get(0).equals("None")) {
//            arr.remove(0);
//            return null;
//        }
//
//        TreeNode root = new TreeNode(Integer.valueOf(arr.get(0)));
//        arr.remove(0);
//        root.left = redeser(arr);
//        root.right = redeser(arr);
//        return root;
//    }
//
//    public static void main(String[] args) {
//        Leetcode449 lee = new Leetcode449();
//        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(7);
//        String s = lee.serialize(root);
//
//        String ss = "4,1,7";
//        TreeNode root2 = lee.deserialize(ss);
//        System.out.println(root2.val);
//
//        //System.out.println(serial);
//    }
//}
