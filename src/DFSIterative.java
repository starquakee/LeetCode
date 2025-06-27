import java.util.*;

public class DFSIterative {
    // 使用邻接表表示图
    private Map<Integer, List<Integer>> graph;

    public DFSIterative() {
        graph = new HashMap<>();
    }

    // 添加边
    public void addEdge(int u, int v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());
        graph.get(u).add(v);
        graph.get(v).add(u); // 无向图需要双向添加
    }

    // 非递归DFS实现（使用栈）
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visited.add(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.print(current + " ");

            // 注意：为了与递归顺序一致，这里需要反向遍历邻居
            List<Integer> neighbors = graph.getOrDefault(current, Collections.emptyList());
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                int neighbor = neighbors.get(i);
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        DFSIterative dfs = new DFSIterative();
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);

        System.out.println("非递归DFS遍历结果:");
        dfs.dfs(2); // 从节点2开始遍历
    }
}