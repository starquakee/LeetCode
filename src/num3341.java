import java.util.Arrays;
import java.util.PriorityQueue;

public class num3341 {

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        int[][] d = new int[n][m];
        boolean[][] v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE/2);
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        d[0][0] = 0;
        PriorityQueue<Integer[]> q = new PriorityQueue<>((a,b)-> a[2]-b[2]);
        q.offer(new Integer[]{0,0,0});

        while (!q.isEmpty()) {
            Integer[] temp = q.poll();
            if (v[temp[0]][temp[1]]) {
                continue;
            }
            v[temp[0]][temp[1]] = true;
            for (int[] dir : dirs) {
                int nx = temp[0] + dir[0];
                int ny = temp[1] + dir[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                int dist = Math.max(d[temp[0]][temp[1]], moveTime[nx][ny]) + 1;
                if (d[nx][ny] > dist) {
                    d[nx][ny] = dist;
                    q.offer(new Integer[]{nx, ny, dist});
                }
            }
        }
        return d[n - 1][m - 1];
    }
}
