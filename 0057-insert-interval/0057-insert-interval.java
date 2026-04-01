class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        List<int[]> intervalsList = new ArrayList<>(); 
        //Step 1 : insert all the arrays and the new aray into its correct position
        int flag = -1;
        for(int[] interval : intervals) {
            if (interval[0] > newInterval[0] && flag == -1) {
                intervalsList.add(newInterval);
                flag++;
            }
            intervalsList.add(interval);
        }
        if (flag == -1) intervalsList.add(newInterval); 

        //Step 2 : Merge overlapping intervals
        for(int[] interval : intervalsList.toArray(new int[intervalsList.size()][])) {

            if (ans.isEmpty() || ans.get(ans.size()-1)[1] < interval[0]) {
                ans.add(interval);
            } else {
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1],interval[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}