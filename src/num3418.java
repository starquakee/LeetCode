public class num3418 {
    public int maximumAmount(int[][] coins) {
        int m=coins.length;
        int n=coins[0].length;
        int ans=Integer.MIN_VALUE;
        int[][][] dp = new int[m][n][3];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=Integer.MIN_VALUE+100;
                }
            }
        }
        dp[0][0][0]=coins[0][0];
        dp[0][0][1]=0;
        for(int i=1;i<m;i++) {
            if(coins[i][0]>0){
                dp[i][0][0] = dp[i - 1][0][0] + coins[i][0];
                dp[i][0][1] = dp[i - 1][0][1] + coins[i][0];
                dp[i][0][2] = dp[i - 1][0][2] + coins[i][0];
            } else {
                dp[i][0][0] = dp[i - 1][0][0] + coins[i][0];
                dp[i][0][1] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1] + coins[i][0]);
                dp[i][0][2] = Math.max(dp[i - 1][0][1], dp[i - 1][0][2] + coins[i][0]);
            }
        }
        for(int j=1;j<n;j++) {
            if(coins[0][j]>0){
                dp[0][j][0] = dp[0][j - 1][0] + coins[0][j];
                dp[0][j][1] = dp[0][j - 1][1] + coins[0][j];
                dp[0][j][2] = dp[0][j - 1][2] + coins[0][j];
            } else {
                dp[0][j][0] = dp[0][j - 1][0] + coins[0][j];
                dp[0][j][1] = Math.max(dp[0][j - 1][0], dp[0][j - 1][1] + coins[0][j]);
                dp[0][j][2] = Math.max(dp[0][j - 1][1], dp[0][j - 1][2] + coins[0][j]);
            }
        }
        for(int i=1;i<m;i++) {
            for (int j = 1; j < n; j++) {
                if (coins[i][j] > 0) {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]) + coins[i][j];
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i][j - 1][1]) + coins[i][j];
                    dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i][j - 1][2]) + coins[i][j];
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]) + coins[i][j];
                    dp[i][j][1] = Math.max(Math.max(dp[i - 1][j][0], dp[i][j - 1][0]), Math.max(dp[i - 1][j][1], dp[i][j - 1][1]) + coins[i][j]);
                    dp[i][j][2] = Math.max(Math.max(dp[i - 1][j][1], dp[i][j - 1][1]), Math.max(dp[i - 1][j][2], dp[i][j - 1][2]) + coins[i][j]);
                }
            }
        }
        for(int i=0;i<3;i++){
            System.out.println(dp[m-1][n-1][i]);
            ans=Math.max(ans, dp[m-1][n-1][i]);
        }
        return ans;
    }
}
