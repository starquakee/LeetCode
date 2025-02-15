public class num1706 {
    public int[] findBall(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i]=i;
        }
        for (int[] row : grid) {
            for (int j = 0; j < n; j++) {
                if (ans[j] != -1) {
                    if ((ans[j] + 1 < n && ans[j] >= 0 && row[ans[j]] == 1 && row[ans[j] + 1] == -1) || (ans[j] - 1 >= 0 && ans[j] < n && row[ans[j]] == -1 && row[ans[j] - 1] == 1) || (ans[j] == 0 && row[ans[j]] == -1) || (ans[j] == n - 1 && row[ans[j]] == 1)) {
                        ans[j] = -1;
                    } else {
                        ans[j] += row[ans[j]];
                    }
                }
            }
        }
        return ans;
    }
}
