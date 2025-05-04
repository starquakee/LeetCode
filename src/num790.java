import java.util.Arrays;

public class num790 {
    private static final int MOD = 1_000_000_007;
    public int numTilings(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;
        int[] dp = new int[n];
        dp[0]=1;
        dp[1]=2;
        dp[2]=5;
        for(int i=3;i<n;i++){
            dp[i]=(dp[i-3]+2*dp[i-1]%MOD)%MOD;
        }
        return dp[n-1];
    }
}
