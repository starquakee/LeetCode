public class num1411 {
    public int numOfWays(int n) {
        int MOD = 1000000007;
        long[][] dp = new long[n][2];
        dp[0][0]=6L;
        dp[0][1]=6L;
        for(int i=1;i<n;i++){
            dp[i][0]=(dp[i-1][0]*3%MOD+dp[i-1][1]*2%MOD)%MOD;
            dp[i][1]=(dp[i-1][0]*2%MOD+dp[i-1][1]*2%MOD)%MOD;
        }
        return (int) ((dp[n-1][0]+dp[n-1][1])%1000000007);
    }
}
