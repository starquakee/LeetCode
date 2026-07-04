import java.util.List;

public class num2492 {
    int minScore=Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new List[n + 1];
        for(int i=0;i<=n;i++){
            graph[i] = new java.util.ArrayList<>();
        }
        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }
        boolean[] visited = new boolean[n + 1];
        dfs(1, visited, graph);
        return minScore;
    }
    public void dfs(int u, boolean[] visited, List<int[]>[] graph) {
        visited[u] = true;
        for (int[] neighbor : graph[u]) {
            int v = neighbor[0];
            int w = neighbor[1];
            minScore = Math.min(minScore, w);
            if (!visited[v]) {
                dfs(v, visited, graph);
            }
        }
    }
}
