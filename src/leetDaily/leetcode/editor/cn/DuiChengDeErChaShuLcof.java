////请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
////
//// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
////
//// 1
//// / \
//// 2 2
//// / \ / \
////3 4 4 3
////但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
////
//// 1
//// / \
//// 2 2
//// \ \
//// 3 3
////
////
////
//// 示例 1：
////
//// 输入：root = [1,2,2,3,4,4,3]
////输出：true
////
////
//// 示例 2：
////
//// 输入：root = [1,2,2,null,3,null,3]
////输出：false
////
////
////
//// 限制：
////
//// 0 <= 节点个数 <= 1000
////
//// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
//// Related Topics 树 深度优先搜索 广度优先搜索 二叉树
//// 👍 197 👎 0
//
//package leetcode.editor.cn;
//
//import java.util.ArrayList;
//
//public class DuiChengDeErChaShuLcof {
//    public static void main(String[] args) {
//        Solution solution = new DuiChengDeErChaShuLcof().new Solution();
////        TreeNode root = new TreeNode(1);
////        TreeNode l = new TreeNode(2);
////        TreeNode r = new TreeNode(2);
////        TreeNode l_r = new TreeNode(3);
////        TreeNode r_r = new TreeNode(3);
////        root.left = l;
////        root.right = r;
////        l.right = l_r;
////        r.right = r_r;
////        System.out.println(solution.isSymmetric(root));
//    }
//    //leetcode submit region begin(Prohibit modification and deletion)
///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode(int x) { val = x; }
// * }
// */
////public static class TreeNode {
////    int val;
////    TreeNode left;
////    TreeNode right;
////    TreeNode(int x) { val = x; }
////}
//
//class Solution {
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null || (root.left == null && root.right == null)) return true;
//        ArrayList<Integer> left = new ArrayList<>();
//        ArrayList<Integer> right = new ArrayList<>();
//        left = leftbianli(left, root.left);
//        right = rightbianli(right, root.right);
//        return left.equals(right);
//    }
//
//    public ArrayList<Integer> leftbianli(ArrayList<Integer> arr, TreeNode root) {
//        if (root == null) {
//            arr.add(0);
//            return arr;
//        }
//        arr.add(root.val);
//        TreeNode tmp_node = root.right;
//        leftbianli(arr, root.left);
//        leftbianli(arr, tmp_node);
//        return arr;
//    }
//
//    public ArrayList<Integer> rightbianli(ArrayList<Integer> arr, TreeNode root) {
//        if (root == null) {
//            arr.add(0);
//            return arr;
//        }
//        arr.add(root.val);
//        TreeNode tmp_node = root.left;
//        rightbianli(arr, root.right);
//        rightbianli(arr, tmp_node);
//        return arr;
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//}
//
///* 递归
//class Solution {
//    public boolean isSymmetric(TreeNode root) {
//        return root == null ? true : recur(root.left, root.right);
//    }
//    boolean recur(TreeNode L, TreeNode R) {
//        if(L == null && R == null) return true;
//        if(L == null || R == null || L.val != R.val) return false;
//        return recur(L.left, R.right) && recur(L.right, R.left);
//    }
//}
// */