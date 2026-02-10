class Solution {
    // private static int f(int i, int j, int matrix[][], int dp[][]) {
    //     if (j < 0 || j >= matrix[0].length) return Integer.MAX_VALUE;
    //     if (i == 0) return matrix[0][j];
    //     if (dp[i][j] != -1) return dp[i][j];

    //     int up = f(i-1,j,matrix,dp);
    //     int ld = f(i-1,j-1,matrix,dp); //left diagonal
    //     int rd = f(i-1,j+1,matrix,dp); //right diagonal

    //     return dp[i][j] = matrix[i][j] + Math.min(up,Math.min(ld,rd));
    // }

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        // for(int i=0; i<m; i++) {
        //     Arrays.fill(dp[i],-1);
        // }

        for(int j=0; j<n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for(int i=1; i<m; i++) {
            for(int j=0; j<n; j++) {
                int ld = Integer.MAX_VALUE;
                int rd = Integer.MAX_VALUE;
                int up = dp[i-1][j];
                if (j-1 >= 0) ld = dp[i-1][j-1];
                if (j+1 < n) rd = dp[i-1][j+1];

                dp[i][j] = matrix[i][j] + Math.min(up,Math.min(ld,rd));
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int j=0; j<n; j++) {
            min = Math.min(min,dp[m-1][j]);
        }
        return min;
    }
}