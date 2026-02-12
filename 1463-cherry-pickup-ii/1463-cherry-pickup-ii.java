class Solution {
    private static int f(int i,int j1,int j2,int grid[][]) {
        //base cases
        if (j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length) {
            return Integer.MIN_VALUE;
        } // if any robot moves out of boundary return min val so path neglected
        if (i == grid.length - 1) { // reached last row in grid
            if (j1 == j2) return grid[i][j1]; //if both same return once
            else return grid[i][j1] + grid[i][j2]; //if both are at different cell
        }

        //Explore all paths
        //For one move of robot 1, robot 2 can make 3 moves, so we convert this into loops
        int max = 0;
        for(int dj1=-1; dj1<=1; dj1++) { //for robot 1 (say)
            for(int dj2=-1; dj2<=1; dj2++) { //for robot 2 (say)
                max = Math.max(f(i+1,j1+dj1,j2+dj2,grid),max); //explore all paths and maintain max among all the returned values for each of the 9 paths.
            }
        }
        if (j1 == j2) return grid[i][j1] + max; //if both are at same cell current cell's value only contributes once.
        else return grid[i][j1] + grid[i][j2] + max; //if both are at diff both contribute separately at current stage.
    }
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return f(0,0,n-1,grid);
    }
}