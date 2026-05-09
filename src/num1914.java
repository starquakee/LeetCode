public class num1914 {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int count = Math.min(m, n) / 2;
        for (int i = 0; i < count; i++) {
            int len = 2 * (m + n - 4 * i) - 4;
            int[] tmp = new int[len];
            int idx = 0;
            for (int j = i; j < n - i; j++) tmp[idx++] = grid[i][j];
            for (int j = i + 1; j < m - i - 1; j++) tmp[idx++] = grid[j][n - i - 1];
            for (int j = n - i - 1; j >= i; j--) tmp[idx++] = grid[m - i - 1][j];
            for (int j = m - i - 2; j > i; j--) tmp[idx++] = grid[j][i];
            int shift = k % len;
            idx = 0;
            for (int j = i; j < n - i; j++) {grid[i][j] = tmp[(idx + shift) % len]; idx++;}
            for (int j = i + 1; j < m - i - 1; j++) {grid[j][n - i - 1] = tmp[(idx + shift) % len]; idx++;}
            for (int j = n - i - 1; j >= i; j--) {grid[m - i - 1][j] = tmp[(idx + shift) % len]; idx++;}
            for (int j = m - i - 2; j > i; j--) {grid[j][i] = tmp[(idx + shift) % len]; idx++;}
        }
        return grid;
    }
}
