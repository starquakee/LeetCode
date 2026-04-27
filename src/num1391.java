import java.util.LinkedList;
import java.util.Queue;

public class num1391 {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 特殊情况：只有一个格子
        if (m == 1 && n == 1) {
            return true;
        }

        // 方向数组：上，右，下，左
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        // BFS 队列与访问标记
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];

            // 到达终点
            if (r == m - 1 && c == n - 1) {
                return true;
            }

            int type = grid[r][c];

            // 尝试四个方向
            for (int d = 0; d < 4; d++) {
                // 当前格子必须能向该方向走
                if (!canGo(type, d)) {
                    continue;
                }

                int nr = r + dirs[d][0];
                int nc = c + dirs[d][1];

                // 越界或已访问
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc]) {
                    continue;
                }

                int nextType = grid[nr][nc];
                // 目标格子必须能从相反方向进入
                if (!canGo(nextType, (d + 2) % 4)) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }

        return false;
    }

    // 判断街道类型 type 在方向 dir 上是否有出口
    // 方向编码：0-上, 1-右, 2-下, 3-左
    private boolean canGo(int type, int dir) {
        switch (type) {
            case 1: // 左右
                return dir == 1 || dir == 3;
            case 2: // 上下
                return dir == 0 || dir == 2;
            case 3: // 左下
                return dir == 2 || dir == 3;
            case 4: // 右下
                return dir == 1 || dir == 2;
            case 5: // 左上
                return dir == 0 || dir == 3;
            case 6: // 右上
                return dir == 0 || dir == 1;
            default:
                return false;
        }
    }
}
