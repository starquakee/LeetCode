public class num840 {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 5) {
                    if (isMagicSquare(grid, i, j)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private boolean isMagicSquare(int[][] grid, int i, int j) {
        boolean[] seen = new boolean[10];

        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                int num = grid[i + di][j + dj];
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }
        for (int di = -1; di <= 1; di++) {
            int sum = 0;
            for (int dj = -1; dj <= 1; dj++) {
                sum += grid[i + di][j + dj];
            }
            if (sum != 15) return false;
        }
        for (int dj = -1; dj <= 1; dj++) {
            int sum = 0;
            for (int di = -1; di <= 1; di++) {
                sum += grid[i + di][j + dj];
            }
            if (sum != 15) return false;
        }
        int diag1 = grid[i-1][j-1] + grid[i][j] + grid[i+1][j+1];
        if (diag1 != 15) return false;
        int diag2 = grid[i-1][j+1] + grid[i][j] + grid[i+1][j-1];
        if (diag2 != 15) return false;
        return true;
    }
}