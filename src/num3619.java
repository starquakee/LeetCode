import java.util.ArrayDeque;

public class num3619 {
    public int countIslands(int[][] grid, int k) {
        int ans=0;
        int[][] dirs={{-1,0},{1,0},{0,1},{0,-1}};
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    ArrayDeque<int[]> deque=new ArrayDeque<>();
                    deque.offer(new int[]{i,j});
                    long sum=grid[i][j];
                    grid[i][j]=0;
                    while (!deque.isEmpty()){
                        int[] poll = deque.poll();
                        int x=poll[0];
                        int y=poll[1];
                        for(int z=0;z<4;z++){
                            int nx=x+dirs[z][0];
                            int ny=y+dirs[z][1];
                            if(nx>=0&&nx<m&&ny>=0&&ny<n&&grid[nx][ny]!=0){
                                deque.offer(new int[]{nx,ny});
                                sum+=grid[nx][ny];
                                grid[nx][ny]=0;
                            }
                        }
                    }
                    if(sum%k==0)ans++;
                }
            }
        }
        return ans;
    }
}
