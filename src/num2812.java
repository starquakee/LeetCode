import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num2812 {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        int[][] dis = new int[n][n];
        for (int[] row : dis) {
            Arrays.fill(row, -1);
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                    dis[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];
            for (int[] dir : dirs) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || dis[nx][ny] != -1) {
                    continue;
                }
                dis[nx][ny] = dis[cx][cy] + 1;
                q.offer(new int[]{nx, ny});
            }
        }

        int lo = 0, hi = Math.min(dis[0][0], dis[n - 1][n - 1]);
        int res = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (check(dis, mid, dirs)) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return res;
    }

    private boolean check(int[][] dis, int limit, int[][] dirs) {
        int n = dis.length;
        boolean[][] visit = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visit[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];
            if (cx == n - 1 && cy == n - 1) {
                return true;
            }
            for (int[] dir : dirs) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n ||
                        visit[nx][ny] || dis[nx][ny] < limit) {
                    continue;
                }
                q.offer(new int[]{nx, ny});
                visit[nx][ny] = true;
            }
        }
        return false;
    }
}
