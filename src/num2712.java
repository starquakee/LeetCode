import java.util.Arrays;

public class num2712 {
    public long minimumCost(String s) {
        long ans = Long.MAX_VALUE;
        int n = s.length();
        long[] prefix = new long[n];
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                prefix[i] = prefix[i - 1];
            } else prefix[i] = prefix[i - 1] + i;
        }
        long[] suffix = new long[n];
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                suffix[i] = suffix[i + 1];
            } else suffix[i] = suffix[i + 1] + n - i - 1;
        }
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, prefix[i] + suffix[i]);
        }
        return ans;
    }
}
