import java.util.Arrays;

public class num837 {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts) return 1.0;
        double[] dp = new double[k + maxPts + 1];
        dp[0] = 1.0;
        double res = 0.0;
        double windowSum = 0.0;
        for (int i = 1; i <= n; i++) {
            int j = Math.max(i - maxPts, 0);
            if(j - 1 >= 0&&j - 1 < k&&j - 1 < i) windowSum -= dp[j - 1];
            int end=i-1;
            if(end < k&&end < i) windowSum += dp[end];
            dp[i] = windowSum/ maxPts ;
            if (i >= k) res += dp[i];
        }
        return res;
    }
}
