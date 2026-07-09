import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num3532 {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int r=0;
        for (int i = 0; i < n; i++) {
            while (r < n && nums[r] - nums[i] <= maxDiff) {
                r++;
            }
            for (int j = i + 1; j < r; j++) {
                graph.get(i).add(j);
                graph.get(j).add(i);
            }
        }
        int[] component = new int[n];
        Arrays.fill(component, -1);
        int compId = 0;
        for (int i = 0; i < n; i++) {
            if (component[i] == -1) {
                dfs(i, graph, component, compId);
                compId++;
            }
        }
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            result[i] = (component[u] == component[v]);
        }
        return result;
    }

    private void dfs(int node, List<List<Integer>> graph, int[] component, int compId) {
        component[node] = compId;
        for (int neighbor : graph.get(node)) {
            if (component[neighbor] == -1) {
                dfs(neighbor, graph, component, compId);
            }
        }
    }
}
