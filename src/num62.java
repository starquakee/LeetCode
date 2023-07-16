public class num62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==j&&i==0)continue;
                if(j>0){
                    dp[i][j] += dp[i][j-1];
                }
                if(i>0){
                    dp[i][j] += dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
