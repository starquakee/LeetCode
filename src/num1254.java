import java.util.ArrayDeque;
import java.util.Queue;

public class num1254 {
//    public static int closedIsland(int[][] grid) {
//        int ans = 0;
//        int[][] direction = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
//        int m = grid.length;
//        int n = grid[0].length;
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(grid[i][j]==0){
//                    Queue<int[]> queue = new ArrayDeque<>();
//                    queue.offer(new int[]{i,j});
//                    grid[i][j]=1;
//                    boolean closed = true;
//                    while (!queue.isEmpty()){
//                        int[] arr = queue.poll();
//                        int x = arr[0];
//                        int y = arr[1];
//                        if(x==0||x==m-1||y==0||y==n-1){
//                            closed = false;
//                        }
//                        for(int count=0;count<4;count++){
//                            int x_new = x+direction[count][0];
//                            int y_new = y+direction[count][1];
//                            if(x_new>=0&&x_new<m&&y_new>=0&&y_new<n&&grid[x_new][y_new]==0){
//                                grid[x_new][y_new] = 1;
//                                queue.offer(new int[]{x_new,y_new});
//                            }
//                        }
//                    }
//                    if(closed){
//                        ans++;
//                    }
//                }
//            }
//        }
//        return ans;
//    }
//    public int closedIsland(int[][] grid) {
//        int ans=0;
//        int n=grid.length;
//        int m=grid[0].length;
//        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
//        Queue<int[]> queue = new ArrayDeque<>();
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                if(grid[i][j]==0){
//                    queue.offer(new int[]{i,j});
//                    grid[i][j]=1;
//                    boolean flag=true;
//                    while (!queue.isEmpty()){
//                        int[] poll = queue.poll();
//                        int ii=poll[0];
//                        int jj=poll[1];
//                        if(ii==0||ii==n-1||jj==0||jj==m-1) flag=false;
//                        for(int k=0;k<dirs.length;k++){
//                            int newX=ii+dirs[k][0];
//                            int newY=jj+dirs[k][1];
//                            if(newX>=0&&newX<n&&newY>=0&&newY<m&&grid[newX][newY]==0){
//                                queue.offer(new int[]{newX,newY});
//                                grid[newX][newY]=1;
//                            }
//                        }
//                    }
//                    if(flag) ans++;
//                }
//            }
//        }
//        return ans;
//    }
    public int closedIsland(int[][] grid) {
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    if(dfs(grid,i,j)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    public boolean dfs(int[][] grid,int i,int j){
        boolean ans=true;
        int n=grid.length;
        int m=grid[0].length;
        if(i<0||i>=n||j<0||j>=m){
            return false;
        }
        if(grid[i][j]==1){
            return true;
        }
        if(i==0||i==n-1||j==0||j==m-1) ans= false;
        grid[i][j]=1;
        boolean b1=dfs(grid,i-1,j);
        boolean b2=dfs(grid,i+1,j);
        boolean b3=dfs(grid,i,j-1);
        boolean b4=dfs(grid,i,j+1);
        return ans&&b1&&b2&&b3&&b4;
    }

}
