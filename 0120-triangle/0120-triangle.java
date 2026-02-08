class Solution {
    private static int getMinimum(List<List<Integer>> triangle,int i,int j,int dp[][]) {
        int rows = triangle.size();
        if(i == rows-1) return (triangle.get(i)).get(j);
        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int down = getMinimum(triangle,i+1,j,dp);
        int diagonal = getMinimum(triangle,i+1,j+1,dp);

        return dp[i][j] = ((triangle.get(i)).get(j) + Math.min(down,diagonal)); 
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int cols = triangle.get(rows-1).size();
        int dp[][] = new int[rows][cols];
        for(int i = 0; i<rows; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        } 
        return getMinimum(triangle,0,0,dp);
    }
}