/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private static boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;

        return left.val == right.val && helper(left.right,right.left) && helper(left.left,right.right);
    }
    public boolean isSymmetric(TreeNode root) {
       if (root == null) return true;
       return helper(root.left,root.right); 
    }
}