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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int direction = 1;
        while (!q.isEmpty()) {
            int n = q.size();
            Integer arr[] = new Integer[n];
            for(int i=0;i<n;i++) {
                TreeNode node = q.poll();
                int index = direction == 1 ? i : n-1-i;
                arr[index] = node.val;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            direction *= -1;
        ans.add(Arrays.asList(arr));
        }

        return ans;
    }
}