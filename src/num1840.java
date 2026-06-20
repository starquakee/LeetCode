import java.util.List;

public class num1840 {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> list = new java.util.ArrayList<>();
        for (int[] restriction : restrictions) {
            list.add(restriction);
        }
        list.add(new int[]{1, 0});
        list.add(new int[]{n, n - 1});
        list.sort((a, b) -> a[0] - b[0]);
        for (int i = 1; i < list.size(); i++) {
            int[] prev = list.get(i - 1);
            int[] curr = list.get(i);
            int maxAllowed = prev[1] + (curr[0] - prev[0]);
            if (curr[1] > maxAllowed) {
                curr[1] = maxAllowed;
            }
        }
        for (int i = list.size() - 2; i >= 0; i--) {
            int[] next = list.get(i + 1);
            int[] curr = list.get(i);
            int maxAllowed = next[1] + (next[0] - curr[0]);
            if (curr[1] > maxAllowed) {
                curr[1] = maxAllowed;
            }
        }
        int maxHeight = 0;
        for (int i = 1; i < list.size(); i++) {
            int[] prev = list.get(i - 1);
            int[] curr = list.get(i);
            int distance = curr[0] - prev[0];
            int heightDiff = Math.abs(curr[1] - prev[1]);
            if (heightDiff > distance) {
                return -1; // Impossible to satisfy the restrictions
            }
            int localMax = Math.max(curr[1], prev[1]) + (distance - heightDiff) / 2;
            maxHeight = Math.max(maxHeight, localMax);
        }
        return maxHeight;
    }
}
