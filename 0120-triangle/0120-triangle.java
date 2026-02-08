class Solution {
    // private static int getMinimum(List<List<Integer>> triangle,int i,int j,int dp[][]) {
    //     int rows = triangle.size();
    //     if(i == rows-1) return (triangle.get(i)).get(j);
    //     if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

    //     int down = getMinimum(triangle,i+1,j,dp);
    //     int diagonal = getMinimum(triangle,i+1,j+1,dp);

    //     return dp[i][j] = ((triangle.get(i)).get(j) + Math.min(down,diagonal)); 
    // }
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int cols = triangle.get(rows-1).size();
        int dp[][] = new int[rows][cols];
        if (rows == 1) return triangle.get(0).get(0);
        int minPathSum = Integer.MAX_VALUE;
        // for(int i = 0; i<rows; i++) {
        //     Arrays.fill(dp[i],Integer.MAX_VALUE);
        // }
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1; i<rows; i++) {
            for(int j=0; j<=i; j++) {
                    
                int up = Integer.MAX_VALUE;
                int diagonal = Integer.MAX_VALUE;
                if (j < i) up = dp[i-1][j];
                if (j > 0) diagonal = dp[i-1][j-1];

                dp[i][j] = triangle.get(i).get(j) + Math.min(up,diagonal);
                if (i == rows-1) {
                    minPathSum = Math.min(minPathSum,dp[i][j]);
                }
            }
        }

        return minPathSum;
    }
}