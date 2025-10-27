import java.util.ArrayDeque;
import java.util.Queue;

public class num200 {
//    void dfs(char[][] grid, int i, int j) {
//        int aLen = grid.length;
//        int bLen = grid[0].length;
//        if(i<0||i>=aLen||j<0||j>=bLen||grid[i][j]=='0'){
//            return;
//        }
//        grid[i][j]='0';
//        dfs(grid,i-1,j);
//        dfs(grid,i+1,j);
//        dfs(grid,i,j-1);
//        dfs(grid,i,j+1);
//    }
//
//    public int numIslands(char[][] grid) {
//        int aLen = grid.length;
//        int bLen = grid[0].length;
//        if(aLen == 0 || bLen == 0){
//            return 0;
//        }
//        int ans = 0;
//        for(int i=0;i<aLen;i++){
//            for(int j=0;j<bLen;j++){
//                if(grid[i][j]=='1'){
//                    dfs(grid,i,j);
//                    ans++;
//                }
//            }
//        }
//        return ans;
//    }
    int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        Queue<int[]> queue = new ArrayDeque();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    queue.offer(new int[]{i,j});
                    grid[i][j] = '0';
                    while (!queue.isEmpty()){
                        int[] poll = queue.poll();
                        int ii=poll[0];
                        int jj=poll[1];
                        for(int k=0;k<dirs.length;k++){
                            int newX=ii+dirs[k][0];
                            int newY=jj+dirs[k][1];
                            if(newX>=0&&newX<n&&newY>=0&&newY<m&&grid[newX][newY]=='1'){
                                queue.offer(new int[]{newX,newY});
                                grid[newX][newY]='0';
                            }
                        }
                    }

                }
            }
        }
        return  ans;
    }
}
