import static java.lang.Math.pow;

public class num2906 {
    public int[][] constructProductMatrix(int[][] grid) {
        final int MOD = 12345;
        int m = grid.length, n = grid[0].length;
        int total = m * n;
        int[] arr = new int[total];
        // 展平为一维
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i * n + j] = grid[i][j] % MOD;
            }
        }

        long[] pre = new long[total];
        long[] suf = new long[total];
        pre[0] = 1;
        for (int i = 1; i < total; i++) {
            pre[i] = (pre[i - 1] * arr[i - 1]) % MOD;
        }
        suf[total - 1] = 1;
        for (int i = total - 2; i >= 0; i--) {
            suf[i] = (suf[i + 1] * arr[i + 1]) % MOD;
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                ans[i][j] = (int)((pre[idx] * suf[idx]) % MOD);
            }
        }
        return ans;
    }
}
