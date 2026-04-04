import java.util.ArrayDeque;
import java.util.Arrays;

public class num2087 {
//    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
//        int m = rowCosts.length;
//        int n = colCosts.length;
//        boolean[][] visited = new boolean[m][n];
//        int x = startPos[0], y = startPos[1];
//        int[][] cost = new int[m][n];
//        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//
//        for (int i = 0; i < m; i++) {
//            Arrays.fill(cost[i], Integer.MAX_VALUE);
//        }
//
//        cost[x][y] = 0;
//        visited[x][y] = true; // 标记起点已进入队列
//
//        ArrayDeque<int[]> queue = new ArrayDeque<>();
//        queue.offer(new int[]{x, y});
//
//        while (!queue.isEmpty()){
//            int[] cur = queue.poll();
//            int curx = cur[0], cury = cur[1];
//
//            // 节点出队，标记为 false，代表它目前不在队列中
//            // 如果后续找到到达该节点更小的代价，它还能再次入队
//            visited[curx][cury] = false;
//
//            // 遍历四个方向
//            for (int[] dir : dirs) {
//                int nx = curx + dir[0];
//                int ny = cury + dir[1];
//
//                // 检查是否越界
//                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
//                    // 如果 nx == curx，说明是左右移动，代价为 colCosts[ny]
//                    // 否则是上下移动，代价为 rowCosts[nx]
//                    int stepCost = (nx == curx) ? colCosts[ny] : rowCosts[nx];
//
//                    // 如果发现了到达 (nx, ny) 更小的代价（松弛操作）
//                    if (cost[curx][cury] + stepCost < cost[nx][ny]) {
//                        cost[nx][ny] = cost[curx][cury] + stepCost;
//
//                        // 如果该节点目前不在队列中，则将其入队以更新其邻居
//                        if (!visited[nx][ny]) {
//                            visited[nx][ny] = true;
//                            queue.offer(new int[]{nx, ny});
//                        }
//                    }
//                }
//            }
//        }
//
//        return cost[homePos[0]][homePos[1]];
//    }
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int r1 = startPos[0], c1 = startPos[1];
        int r2 = homePos[0], c2 = homePos[1];
        int res = 0;
        if (r2 >= r1) {
            for (int i = r1 + 1; i <= r2; i++) {
                res += rowCosts[i];
            }
        } else {
            for (int i = r2; i < r1; i++) {
                res += rowCosts[i];
            }
        }
        if (c2 >= c1) {
            for (int i = c1 + 1; i <= c2; i++) {
                res += colCosts[i];
            }
        } else {
            for (int i = c2; i < c1; i++) {
                res += colCosts[i];
            }
        }
        return res;
    }
}
