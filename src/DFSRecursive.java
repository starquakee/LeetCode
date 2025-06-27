import java.util.*;

public class DFSRecursive {
    // 使用邻接表表示图
    private Map<Integer, List<Integer>> graph;
    private Set<Integer> visited;

    public DFSRecursive() {
        graph = new HashMap<>();
        visited = new HashSet<>();
    }

    // 添加边
    public void addEdge(int u, int v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());
        graph.get(u).add(v);
        graph.get(v).add(u); // 无向图需要双向添加
    }

    // 递归DFS实现
    public void dfs(int start) {
        visited.add(start);
        System.out.print(start + " ");

        for (int neighbor : graph.getOrDefault(start, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        DFSRecursive dfs = new DFSRecursive();
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);

        System.out.println("递归DFS遍历结果:");
        dfs.dfs(2); // 从节点2开始遍历
    }
}