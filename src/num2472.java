public class num2472 {
    public int maxPalindromes(String s, int k) {
        final int n = s.length();

        boolean[][] palindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            palindrome[i][i] = true;
            for (int l = i - 1, r = i + 1; l >= 0 && r < n && s.charAt(l) == s.charAt(r); l--, r++) {
                palindrome[l][r] = true;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                palindrome[i][i + 1] = true;
                for (int l = i - 1, r = i + 2; l >= 0 && r < n && s.charAt(l) == s.charAt(r); l--, r++) {
                    palindrome[l][r] = true;
                }
            }
        }

        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i + 1] = dp[i];
            for (int j = 0; j <= i - k + 1; j++) {
                if (palindrome[j][i]) {
                    dp[i + 1] = Math.max(dp[i + 1], dp[j] + 1);
                }
            }
        }
        return dp[n];
    }
}
