import java.util.Arrays;
import java.util.PriorityQueue;

public class num3342 {
    public int minTimeToReach(int[][] moveTime) {
        int n=moveTime.length,m=moveTime[0].length;
        int[][] d = new int[n][m];
        boolean[][] isVisited = new boolean[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(d[i], Integer.MAX_VALUE/2);

        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new Integer[]{0,0,0,1});
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!pq.isEmpty()){
            Integer[] temp = pq.poll();
            int x=temp[0];
            int y=temp[1];
            int dist=temp[2];
            int takeTime=temp[3];
            if(isVisited[x][y])continue;
            isVisited[x][y]=true;
            for(int i=0;i<4;i++){
                int nx= x+dirs[i][0];
                int ny= y+dirs[i][1];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)continue;
                int distance=Math.max(moveTime[nx][ny],dist)+takeTime;
                if(distance<d[nx][ny]){
                    d[nx][ny]=distance;
                    int newTakeTime=takeTime%2+1;
                    pq.offer(new Integer[]{nx,ny,distance,newTakeTime});
                }
            }
        }
        return d[n-1][m-1];
    }
}
