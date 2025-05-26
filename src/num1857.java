import java.util.*;

public class num1857 {
    //copy
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        // 邻接表
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            g.add(new ArrayList<>());
        }
        // 节点的入度统计，用于找出拓扑排序中最开始的节点
        int[] indeg = new int[n];
        for (int[] edge : edges) {
            ++indeg[edge[1]];
            g.get(edge[0]).add(edge[1]);
        }

        // 记录拓扑排序过程中遇到的节点个数
        // 如果最终 found 的值不为 n，说明图中存在环
        int found = 0;
        int[][] f = new int[n][26];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            ++found;
            int u = q.poll();
            // 将节点 u 对应的颜色增加 1
            ++f[u][colors.charAt(u) - 'a'];
            // 枚举 u 的后继节点 v
            for (int v : g.get(u)) {
                --indeg[v];
                // 将 f(v,c) 更新为其与 f(u,c) 的较大值
                for (int c = 0; c < 26; ++c) {
                    f[v][c] = Math.max(f[v][c], f[u][c]);
                }
                if (indeg[v] == 0) {
                    q.offer(v);
                }
            }
        }
        if (found != n) {
            return -1;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, Arrays.stream(f[i]).max().getAsInt());
        }
        return ans;
    }
}
