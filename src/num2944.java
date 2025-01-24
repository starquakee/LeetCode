import java.util.Arrays;

public class num2944 {
    public int minimumCoins(int[] prices) {
        int[] dp = new int[prices.length+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=prices.length;i++){
            for(int j=(i-1)/2;j<i;j++){
                dp[i] = Math.min(dp[i],dp[j]+prices[j]);
            }
        }
        return dp[prices.length];
    }
}
