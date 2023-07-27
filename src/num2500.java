import java.util.Arrays;

public class num2500 {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int[] row : grid) Arrays.sort(row);
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, grid[j][n - i - 1]);
            }
            ans += max;
        }
        return ans;
    }
}
