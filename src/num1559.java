public class num1559 {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        // 从每个未访问的格子开始DFS
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited,
                        int x, int y, int parentX, int parentY) {
        int m = grid.length;
        int n = grid[0].length;
        visited[x][y] = true;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] d : dirs) {
            int nx = x + d[0];
            int ny = y + d[1];

            // 越界或值不同则跳过
            if (nx < 0 || nx >= m || ny < 0 || ny >= n ||
                    grid[nx][ny] != grid[x][y]) {
                continue;
            }
            // 不走回头路
            if (nx == parentX && ny == parentY) {
                continue;
            }
            // 发现已访问的相邻同值格子 -> 存在环
            if (visited[nx][ny]) {
                return true;
            }
            // 继续深搜
            if (dfs(grid, visited, nx, ny, x, y)) {
                return true;
            }
        }
        return false;
    }
}
