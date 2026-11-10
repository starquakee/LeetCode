import java.util.Arrays;

public class num3693 {
    public int climbStairs(int n, int[] costs) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<n;i++){
            dp[i+1]=Math.min(dp[i+1],dp[i]+costs[i]+1);
            if(i+2<=n) dp[i+2]=Math.min(dp[i+2],dp[i]+costs[i+1]+4);
            if(i+3<=n) dp[i+3]=Math.min(dp[i+3],dp[i]+costs[i+2]+9);
        }
        return dp[n];
    }
}
