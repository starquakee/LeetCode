public class num518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                if(coin<=i){
                    dp[i] += dp[i-coin];
                }
            }
        }
        return dp[amount];
    }
}
