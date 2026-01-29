import java.util.Arrays;

public class num2976 {
    private static final int INF = Integer.MAX_VALUE / 2;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] G = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(G[i], INF);
            G[i][i] = 0;
        }

        int m = original.length;
        for (int i = 0; i < m; i++) {
            int idx = original[i] - 'a';
            int idy = changed[i] - 'a';
            G[idx][idy] = Math.min(G[idx][idy], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (G[i][k] != INF && G[k][j] != INF) {
                        G[i][j] = Math.min(G[i][j], G[i][k] + G[k][j]);
                    }
                }
            }
        }

        int n = source.length();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int idx = source.charAt(i) - 'a';
            int idy = target.charAt(i) - 'a';
            if (G[idx][idy] == INF) {
                return -1;
            }
            ans += G[idx][idy];
        }

        return ans;
    }
}
