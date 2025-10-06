public class num778 {
    public int N;

    public static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int swimInWater(int[][] grid) {
        N = grid.length;
        int left = 0;
        int right = N*N;
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean[][] visited = new boolean[N][N];
            if(grid[0][0]<=mid&&dfs(grid,0,0,visited,mid)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean dfs(int[][] grid, int row, int col,boolean[][] visited,int amount) {
        if (row == N - 1 && col == N - 1) {
            return true;
        }
        visited[row][col] = true;
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (inArea(newRow, newCol) && !visited[newRow][newCol] && grid[newRow][newCol] <= amount) {
                if(dfs(grid, newRow, newCol, visited, amount)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean inArea(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < N;
    }
}
