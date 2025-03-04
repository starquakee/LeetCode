import java.util.Arrays;

public class num1745 {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(isPalindrome[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1];
            }
        }
        for (int start = 1; start < n - 1; start ++) {
            if (!isPalindrome[0][start - 1]) {
                continue;
            }
            for (int end = start; end < n - 1; end ++) {
                if (isPalindrome[start][end] && isPalindrome[end + 1][n - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
