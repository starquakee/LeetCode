import java.util.Arrays;

public class num2360 {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int ans = -1;
        int[] visitTime = new int[n];
        Arrays.fill(visitTime, -1);
        int time = 0;
        for (int i = 0; i < n; i++) {
            if (visitTime[i] != -1) {
                continue;
            }
            int startTime = time;
            int cur = i;
            while (cur != -1 && visitTime[cur] == -1) {
                visitTime[cur] = time++;
                cur = edges[cur];
            }
            if (cur != -1 && visitTime[cur] >= startTime) {
                ans = Math.max(ans, time - visitTime[cur]);
            }
        }
        return ans;
    }
}
