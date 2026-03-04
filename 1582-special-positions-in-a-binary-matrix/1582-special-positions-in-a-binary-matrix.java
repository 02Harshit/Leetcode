class Solution {

    private static boolean check (int[][] mat,int i,int j,int m,int n) {
        for(int row=0;row<m;row++) {
            if (row == i) continue;
            if (mat[row][j] == 1) return false;
        }
        for(int col=0;col<n;col++) {
            if (col == j) continue;
            if (mat[i][col] == 1) return false;
        }
        return true;
    }
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (mat[i][j] == 1) {
                    if (check(mat,i,j,m,n) == true) count++; 
                }
            }
        }

        return count;
    }
}