import java.util.Arrays;

public class num1278 {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] f = new int[n + 1][k + 1];
        for (int[] row : f) {
            Arrays.fill(row, 1000000000);
        }
        f[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(k, i); j++) {
                if (j == 1) {
                    f[i][j] = cost(0, i - 1, s);
                } else {
                    for (int i0 = j - 1; i0 < i; i0++) {
                        f[i][j] = Math.min(f[i][j], f[i0][j - 1] + cost(i0, i - 1, s));
                    }
                }
            }
        }

        return f[n][k];
    }

    private int cost(int l, int r, String s) {
        int ret = 0;
        int i = l, j = r;
        while (i < j) {
            ret += (s.charAt(i) == s.charAt(j) ? 0 : 1);
            i++;
            j--;
        }
        return ret;
    }
}
