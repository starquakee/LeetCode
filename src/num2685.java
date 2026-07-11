import java.util.ArrayList;
import java.util.List;

public class num2685 {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] cnt = new int[2];
                dfs(i, graph, visited, cnt);
                if (cnt[1] == cnt[0] * (cnt[0] - 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int u, List<List<Integer>> graph, boolean[] visited, int[] cnt) {
        visited[u] = true;
        cnt[0]++;
        cnt[1] += graph.get(u).size();
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                dfs(v, graph, visited, cnt);
            }
        }
    }
}
