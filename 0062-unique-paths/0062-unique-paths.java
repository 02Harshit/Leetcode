class Solution {
    // private static int findWays (int i, int j, int dp[][]) {
    //     if (i < 0 || j < 0) return 0;
    //     if (i == 0 && j == 0) return 1;
    //     if (dp[i][j] != -1) return dp[i][j];

    //     return dp[i][j] = findWays(i-1,j,dp) + findWays(i,j-1,dp);
    // }

    public int uniquePaths(int m, int n) {
        // int dp[][] = new int[m][n];
        // for (int i=0; i<m; i++) {
        //     Arrays.fill(dp[i],-1);
        // }
        int prev[] = new int[n];
        for(int i=0; i<m; i++) {
            int temp[] = new int[n];
            for(int j=0; j<n; j++) {
                if (i == 0 && j == 0) temp[j] = 1;
                else {
                    int up = 0;
                    int left = 0;
                    if (i > 0) up = prev[j];
                    if (j > 0) left = temp[j-1];
                    temp[j] = up + left;
                }
            }
            prev = temp;
        }
        return prev[n-1];
    }
}