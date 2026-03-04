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
    private static int maxHeight(TreeNode root) {
        if (root == null) return 0;
        int left = maxHeight(root.left);
        int right = maxHeight(root.right);
        if (left == -1 || right == -1) return -1;
        if (Math.abs(left - right)> 1) return -1;
        return 1 + Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        if (maxHeight(root) == -1) {
            return false; 
        } else {
            return true;
        }
    }
}