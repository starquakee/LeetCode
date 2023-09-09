import java.util.Arrays;

public class zeroonepackage {
    public static int knapsack(int[] values, int[] weights, int W) {
        int n = values.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));

        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] values = {6, 10, 12};
        int[] weights = {1, 2, 3};
        int W = 5;
        int maxVal = knapsack(values, weights, W);
        System.out.println("Maximum value: " + maxVal);
    }
}
