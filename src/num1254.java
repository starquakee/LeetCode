import java.util.ArrayDeque;
import java.util.Queue;

public class num1254 {
    public static int closedIsland(int[][] grid) {
        int ans = 0;
        int[][] direction = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
//                System.out.println(i+" "+j);
                if(grid[i][j]==0){
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{i,j});
                    grid[i][j]=1;
                    boolean closed = true;
                    while (!queue.isEmpty()){
                        int[] arr = queue.poll();
                        int x = arr[0];
                        int y = arr[1];
                        if(x==0||x==m-1||y==0||y==n-1){
                            closed = false;
                        }
                        for(int count=0;count<4;count++){
                            int x_new = x+direction[count][0];
                            int y_new = y+direction[count][1];
                            if(x_new>=0&&x_new<m&&y_new>=0&&y_new<n&&grid[x_new][y_new]==0){
                                grid[x_new][y_new] = 1;
                                queue.offer(new int[]{x_new,y_new});
                            }
                        }
                    }
                    if(closed){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(closedIsland(new int[][]{{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}}));
    }
}
