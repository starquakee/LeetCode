import java.util.Arrays;

public class num279 {
    public static int numSquares(int n) {
        int size = (int) Math.sqrt(n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        int[] coins = new int[size];
        for(int i=1;i<=size;i++){
            coins[i-1] = i*i;
        }
        for(int i=2;i<=n;i++){
            for(int j=0;j<size;j++){
                if(i>=coins[j]){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
