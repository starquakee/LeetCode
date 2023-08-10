import java.util.Arrays;

public class num1289 {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        System.arraycopy(grid[0], 0, dp[0], 0, n);
        int ans = 99999999;
        int min = 99999999;
        int min_index = 0;

        for (int i = 0; i < n; i++) {
            if (min > grid[0][i]) {
                min = grid[0][i];
                min_index = i;
            }
        }
        if (m == 1) return min;
        
        for (int i = 1; i < m; i++) {
            System.out.println(min + "  " + min_index);
            for (int j = 0; j < n; j++) {
                if (j != min_index) {
                    dp[i][j] = min + grid[i][j];
                } else {
                    int shang_min = 99999999;
                    for (int k = 0; k < n; k++) {
                        if (k != j) {
                            shang_min = Math.min(shang_min, dp[i - 1][k]);
                        }
                    }
                    dp[i][j] = shang_min + grid[i][j];
                }
            }
            min = 99999999;
            for (int j = 0; j < n; j++) {
                if (dp[i][j] < min) {
                    min = dp[i][j];
                    min_index = j;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }
//        System.out.println(Arrays.deepToString(dp));
        return ans;
    }
}
