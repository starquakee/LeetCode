public class num200 {
    void dfs(char[][] grid, int i, int j) {
        int aLen = grid.length;
        int bLen = grid[0].length;
        if(i<0||i>=aLen||j<0||j>=bLen||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }

    public int numIslands(char[][] grid) {
        int aLen = grid.length;
        int bLen = grid[0].length;
        if(aLen == 0 || bLen == 0){
            return 0;
        }
        int ans = 0;
        for(int i=0;i<aLen;i++){
            for(int j=0;j<bLen;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
}
