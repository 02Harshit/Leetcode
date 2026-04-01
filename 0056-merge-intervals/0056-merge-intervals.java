class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();

        //sorting 
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        for (int[] interval : intervals) {
            // If 'ans' is empty or no overlap
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < interval[0]) {
                ans.add(interval);
            } 
            // If there IS an overlap
            else {
                // Just update the end time of the last added interval
                int currentEnd = ans.get(ans.size() - 1)[1];
                ans.get(ans.size() - 1)[1] = Math.max(currentEnd, interval[1]);
            }
        }

        // Convert the List back to a 2D array for the return type
        return ans.toArray(new int[ans.size()][]);        
    }
}