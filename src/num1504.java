public class num1504 {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    dp[i][j] = 0;
                }else  {
                    if(j > 0) {
                        dp[i][j] = dp[i][j-1] + 1;
                    }else if(j==0)  {
                        dp[i][j] = mat[i][j];
                    }
                }
                int preMin = 0;
                for(int k = i; k >= 0; k--) {
                    if(k == i) {
                        ans += dp[i][j];
                        preMin = dp[i][j];
                    }else {
                        if(preMin==0) break;
                        preMin = Math.min(preMin, dp[k][j]);
                        ans += preMin;
                    }
                }
            }
        }
        return ans;
    }
}
