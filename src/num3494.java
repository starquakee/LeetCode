public class num3494 {
    public long minTime(int[] skill, int[] mana) {
        int n=skill.length;
        int m=mana.length;
        long[][] dp=new long[m+1][n+1];
        dp[0][0]= (long) skill[0] *mana[0];
        for(int j=1;j<n;j++) {
            dp[0][j] = dp[0][j - 1] + (long) skill[j] * mana[0];
        }
        for(int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]+(long) skill[0]*mana[i];
            for(int j=1;j<n;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + (long) skill[j] * mana[i];
            }
            for(int j=n-2;j>=0;j--){
                dp[i][j] = dp[i][j+1] - (long) skill[j+1] * mana[i];
            }
        }
        return dp[m-1][n-1];
    }
}
