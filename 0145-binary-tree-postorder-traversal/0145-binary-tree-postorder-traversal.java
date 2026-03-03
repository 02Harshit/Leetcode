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

    private static void post(TreeNode root, List<Integer> l1) {
        if (root == null) return;
        post(root.left,l1);
        post(root.right,l1);
        l1.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) { 
        List<Integer> l1 = new ArrayList<Integer>();
        post(root,l1);
        return l1;
    }
}