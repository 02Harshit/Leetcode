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
    int col;
    Tuple(TreeNode node,int row,int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        q.offer(new Tuple(root,0,0));
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            TreeNode node = t.node;
            int vertical = t.col;
            int level = t.row;

            if (!map.containsKey(vertical)) {
                map.put(vertical,new TreeMap<>());
            }

            if (!map.get(vertical).containsKey(level)) {
                map.get(vertical).put(level,new PriorityQueue<>());
            }

            map.get(vertical).get(level).offer(node.val);

            if (node.left != null) q.offer(new Tuple(node.left,level+1,vertical-1));
            if (node.right != null) q.offer(new Tuple(node.right,level+1,vertical+1));
        }

        ArrayList<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> verticals : map.values()) {
            ArrayList<Integer> l1 = new ArrayList<>();
            for(PriorityQueue<Integer> value : verticals.values()) {
                while (!value.isEmpty()) {
                    l1.add(value.poll());
                }
            }
            list.add(l1);
        }

        return list;

    }
}