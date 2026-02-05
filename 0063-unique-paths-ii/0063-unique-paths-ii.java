class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; //rows
        int n = obstacleGrid[0].length; //cols
        int prev[] = new int[n]; //maintains the track of previous row value
        for(int i=0; i<m; i++) {
            int curr[] = new int[n]; //maintains the track of left value in same row (later becomes prev)
            for(int j=0; j<n; j++) {
                if (obstacleGrid[i][j] == 1) curr[j] = 0; //path blocked
                else if (i == 0 && j == 0) curr[j] = 1; //entry square
                else {
                    int up = 0;
                    int left = 0;
                    if (i > 0) up = prev[j];
                    if (j > 0) left = curr[j-1];
                    curr[j] = up+left;
                }
            }
            prev = curr;
        }
        return prev[n-1];
    }
}