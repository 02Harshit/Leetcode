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
    int index;

    public Tuple(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root,0));
        int max = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int lowest = 0;
            int highest = 0;
            for (int i=0; i<size; i++) {
                Tuple tuple = q.poll();
                TreeNode node = tuple.node;
                int index = tuple.index;
                if (i == 0) { //first node of current level
                    lowest = index;
                }
                int currIndex = index-lowest;

                if (i == size-1) { //last node of current level
                    highest = index; 
                }
                
                if (node.left != null) q.offer(new Tuple(node.left,2*currIndex+1));
                if (node.right != null) q.offer(new Tuple(node.right,2*currIndex+2));
            }
            max = Math.max(max,highest-lowest+1);
        }

        return max;
    }
}