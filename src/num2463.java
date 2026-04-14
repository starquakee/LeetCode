import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class num2463 {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        int n = robot.size(), m = factory.length;
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE / 2);
        }
        for (int j = 1; j <= m; j++) {
            for (int i = 1; i <= n; i++) {
                dp[i][j] = dp[i][j - 1];
                long cost = 0;
                for (int k = 1; k <= Math.min(i, factory[j - 1][1]); k++) {
                    cost += Math.abs((long) robot.get(i - k) - factory[j - 1][0]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + cost);
                }
            }
        }
        return dp[n][m];
    }
}
