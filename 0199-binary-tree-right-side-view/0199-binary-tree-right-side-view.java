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
class Tuple {
    TreeNode node;
    int row;

    public Tuple(TreeNode node, int row) {
        this.node = node;
        this.row = row;
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();

        q.offer(new Tuple(root,0));

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int row = tuple.row;

            map.put(row,node.val);

            if (node.left != null) q.offer(new Tuple(node.left,row+1));
            if (node.right != null) q.offer(new Tuple(node.right,row+1));


        }

        for(Integer val : map.values()) {
            ans.add(val);
        }

        return ans;
    }
}