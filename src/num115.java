public class num115 {
    public int numDistinct(String s, String t) {
        long[] dp = new long[t.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = t.length() - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[j + 1] += dp[j];
                }
            }
        }
        return (int) dp[t.length()];
    }
}
