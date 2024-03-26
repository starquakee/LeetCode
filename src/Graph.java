import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Graph {
    private List<int[]>[] list;

    public Graph(int n, int[][] edges) {
        list = new ArrayList[n];
        for(int i=0;i<n;i++){
            list[i] = new ArrayList<>();
        }
        for(int[] edge:edges) {
            list[edge[0]].add(new int[]{edge[1], edge[2]});
        }
    }

    public void addEdge(int[] edge) {
        list[edge[0]].add(new int[]{edge[1], edge[2]});
    }

    public int shortestPath(int node1, int node2) {
        int[] distance = new int[list.length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[node1] = 0;
        boolean[] visited = new boolean[list.length];
        for(int i=0;i<list.length;i++){
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int j=0;j<list.length;j++){
                if(!visited[j]&&distance[j]<min){
                    min = distance[j];
                    minIndex = j;
                }
            }
            if(minIndex==-1)break;
            visited[minIndex] = true;
            distance[minIndex] = min;
            for(int[] edge:list[minIndex]){
                distance[edge[0]] = Math.min(distance[edge[0]], distance[minIndex]+edge[1]);
            }
        }
        return distance[node2]==Integer.MAX_VALUE?-1:distance[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */