import java.util.*;

public class num417 {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] heights;
    int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        this.heights = heights;
        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];
        for (int i = 0; i < m; i++) {
            bfs(i,0,pacific);
        }
        for (int i = 0; i < n; i++) {
            bfs(0,i,pacific);
        }
        for (int i = 0; i < n; i++) {
            bfs(m-1,i,atlantic);
        }
        for (int i = 0; i < m; i++) {
            bfs(i,n-1,atlantic);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(atlantic[i][j]==1&&pacific[i][j]==1){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
    public void bfs(int row, int col, int[][] ocean) {
        if(ocean[row][col] == 1)return;
        Queue<int[]> q = new ArrayDeque<>();
        ocean[row][col] = 1;
        q.offer(new int[]{row, col});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && ocean[newRow][newCol] == 0 && heights[newRow][newCol] >= heights[x][y]) {
                    bfs(newRow, newCol, ocean);
                }
            }
        }
    }
}
