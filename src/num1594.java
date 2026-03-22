public class num1594 {
    public int maxProductPath(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int MOD=1000000007;
        long[][][] dp = new long[m][n][2];
        dp[0][0][0]=dp[0][0][1]=grid[0][0];
        for(int i=1;i<m;i++){
            dp[i][0][0]=dp[i-1][0][0]*grid[i][0];
            dp[i][0][1]=dp[i-1][0][1]*grid[i][0];
        }
        for(int j=1;j<n;j++){
            dp[0][j][0]=dp[0][j-1][0]*grid[0][j];
            dp[0][j][1]=dp[0][j-1][1]*grid[0][j];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                long a=dp[i-1][j][0]*grid[i][j];
                long b=dp[i-1][j][1]*grid[i][j];
                long c=dp[i][j-1][0]*grid[i][j];
                long d=dp[i][j-1][1]*grid[i][j];
                dp[i][j][0]=Math.max(Math.max(a,b),Math.max(c,d));
                dp[i][j][1]=Math.min(Math.min(a,b),Math.min(c,d));
            }
        }
        return (int)((dp[m-1][n-1][0]<0)?-1:(dp[m-1][n-1][0]%MOD));
    }
}
