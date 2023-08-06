public class num980 {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int uniquePathsIII(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        int si = 0, sj = 0, num_0 = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0) {
                    num_0++;
                } else if (grid[i][j] == 1) {
                    num_0++;
                    si = i;
                    sj = j;
                }
            }
        }
        return dfs(grid, si, sj, num_0);
    }

    public int dfs(int[][] grid, int i, int j, int n) {
        if(grid[i][j]==2)return n==0?1:0;
        int rows = grid.length;
        int columns= grid[0].length;
        int num = grid[i][j];
        grid[i][j] = -1;
        int ans = 0;
        for(int[] dir:dirs){
            int new_i = dir[0]+i;
            int new_j = dir[1]+j;
            if(new_i>=0&&new_i<rows&&new_j>=0&&new_j<columns){
                if(grid[new_i][new_j]!=-1){
                    ans += dfs(grid,new_i,new_j,n-1);
                }
            }
        }
        grid[i][j] = num;
        return ans;
    }
}
