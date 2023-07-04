import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class num994 {
    public int orangesRotting(int[][] grid) {
        int aLen = grid.length;
        int bLen = grid[0].length;
        int time = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0;i<aLen;i++){
            for(int j=0;j<bLen;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        boolean bb=true;
        for(int i=0;i<aLen;i++){
            for(int j=0;j<bLen;j++){
                if(grid[i][j]!=0){
                    bb=false;
                }
            }
        }
        if(bb)return 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            System.out.println(queue.size());
            if(size==1){
                System.out.println(queue.peek()[0]+" "+queue.peek()[1]);
            }
            for(int i=0;i<size;i++){
                int[] arr = queue.poll();
                int a = arr[0];
                int b = arr[1];
                //dfs(grid,a,b);
                if(inside(a+1,b,aLen,bLen,grid)){
                    queue.offer(new int[]{a+1,b});
                    grid[a+1][b]=2;
                }
                if(inside(a-1,b,aLen,bLen,grid)){
                    queue.offer(new int[]{a-1,b});
                    grid[a-1][b]=2;
                }
                if(inside(a,b+1,aLen,bLen,grid)){
                    queue.offer(new int[]{a,b+1});
                    grid[a][b+1]=2;
                }
                if(inside(a,b-1,aLen,bLen,grid)){
                    queue.offer(new int[]{a,b-1});
                    grid[a][b-1]=2;
                }
            }
            time++;
            System.out.println(Arrays.deepToString(grid));
            System.out.println();
        }
        for (int[] ints : grid) {
            for (int j = 0; j < bLen; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }
        return time-1;
    }
    public boolean inside(int a,int b,int sizea,int sizeb,int[][] grid){
        if(a<0||a>=sizea||b<0||b>=sizeb)return false;
        return grid[a][b] == 1;
    }
}
