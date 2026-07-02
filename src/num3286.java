import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class num3286 {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.get(0).size();
        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dis[i], -1);
        }
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid.get(0).get(0), 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curHealth = cur[0], x = cur[1], y = cur[2];
            if(dis[x][y] != -1) {
                continue;
            }
            dis[x][y] = curHealth;
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }
                if(dis[nx][ny] != -1) {
                    continue;
                }
                int nextHealth = curHealth + grid.get(nx).get(ny);
                pq.offer(new int[]{nextHealth, nx, ny});
            }
        }
        return dis[m - 1][n - 1] < health;
    }
}
