import java.util.Arrays;

public class num2617 {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, 9999999);
        }
        dp[0][0] = 1;
        for(int i=0;i<n-1;i++){
            int value = grid[0][i];
            for(int j=1;j<=value;j++){
                if(i+j<n){
                    dp[0][i+j] = Math.min(dp[0][i+j],dp[0][i]+1);
                }
            }
        }
        for(int i=0;i<m-1;i++){
            int value = grid[i][0];
            for(int j=1;j<=value;j++){
                if(i+j<m){
                    dp[i+j][0] = Math.min(dp[i+j][0],dp[i][0]+1);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int value = grid[i][j];
                int k=1;
                if(j>0){
                    k = grid[i][j-1];
                }
                for(;k<=value;k++){
                    if(j+k<n){
                        dp[i][j+k] = Math.min(dp[i][j+k],dp[i][j]+1);
                    }
                }
                k=1;
                if(i>0){
                    k = grid[i-1][j];
                }
                for(;k<=value;k++){
                    if(i+k<m){
                        dp[i+k][j] = Math.min(dp[i+k][j],dp[i][j]+1);
                    }
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        if(dp[m-1][n-1]==9999999)return -1;
        return dp[m-1][n-1];
    }
}
