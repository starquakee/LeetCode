import java.util.Arrays;

public class dijkstra {
    // 一个很大的数，表示两个节点之间没有直接的路径
    private static final int NO_PATH = Integer.MAX_VALUE;

    // 实现Dijkstra算法的方法
    public static void dijkstra(int graph[][], int source) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, NO_PATH);
        dist[0] = 0;
        for(int i=0;i<n-1;i++){
            int u = minDistance(dist,visited);
            visited[u] = true;
            for(int v=0;v<n;v++){
                if(!visited[v]&&graph[u][v]!=0&&dist[u]+graph[u][v]<dist[v]){
                    dist[v] = dist[u]+graph[u][v];
                }
            }
        }
        printSolution(dist);
    }

    // 辅助函数，用于找到距离最小的顶点
    private static int minDistance(int[] dist, boolean[] visited) {
        int min = NO_PATH, minIndex = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // 打印最短距离数组
    private static void printSolution(int[] dist) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < dist.length; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    // 测试Dijkstra算法
    public static void main(String[] args) {
        /* 例子图的邻接矩阵表示 */
        int graph[][] = new int[][] {
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
        };
        dijkstra(graph, 0);
    }
}
