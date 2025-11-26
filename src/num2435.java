public class num2435 {
    public int numberOfPaths(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        long[][][] dp = new long[m][n][k];
        int MOD= (int) (1e9+7);
        dp[0][0][grid[0][0]%k]=1;
        for(int i=1;i<m;i++){
            for(int j=0;j<k;j++){
                dp[i][0][(j+grid[i][0])%k]=dp[i-1][0][j];
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<k;j++){
                dp[0][i][(j+grid[0][i])%k]=dp[0][i-1][j];
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                for(int l=0;l<k;l++){
                    dp[i][j][(l+grid[i][j])%k]=(dp[i-1][j][l]+dp[i][j-1][l])%MOD;
                }
            }
        }
        return (int)dp[m-1][n-1][0];
    }
}
