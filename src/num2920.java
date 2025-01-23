import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num2920 {
     // cv
    public int maximumPoints(int[][] edges, int[] coins, int k) {
        int n = coins.length;
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            children.get(edge[0]).add(edge[1]);
            children.get(edge[1]).add(edge[0]);
        }
        int[][] memo = new int[n][14];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, -1, 0, coins, k, children, memo);
    }

    private int dfs(int node, int parent, int f, int[] coins, int k, List<List<Integer>> children, int[][] memo) {
        if (memo[node][f] != -1) {
            return memo[node][f];
        }
        int res0 = (coins[node] >> f) - k;
        int res1 = coins[node] >> (f + 1);
        for (int child : children.get(node)) {
            if (child == parent) {
                continue;
            }
            res0 += dfs(child, node, f, coins, k, children, memo);
            if (f + 1 < 14) {
                res1 += dfs(child, node, f + 1, coins, k, children, memo);
            }
        }
        memo[node][f] = Math.max(res0, res1);
        return memo[node][f];
    }
}
