import java.util.ArrayDeque;
import java.util.Arrays;

public class num695 {
    int[][] dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    int[][] g;
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        int m=grid.length;
        int n=grid[0].length;
        g=grid;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(g[i][j]==1){
                    ans=Math.max(ans,bfs(i,j,m,n));
                }
            }
        }
        return ans;
    }
    public int bfs(int i,int j,int m,int n){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{i,j});
        g[i][j]=0;
        int ans=0;
        while (!deque.isEmpty()){
            int[] poll = deque.poll();
            int x=poll[0];
            int y=poll[1];
            ans++;
            for(int a=0;a<4;a++){
                int newX=x+dirs[a][0];
                int newY=y+dirs[a][1];
                if(newX>=0&&newX<m&&newY>=0&&newY<n&&g[newX][newY]==1){
                    deque.offer(new int[]{newX,newY});
                    g[newX][newY]=0;
                }
            }
        }
        return ans;
    }
}
