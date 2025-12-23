import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class num2054 {
    public int maxTwoEvents(int[][] events) {
        List<int[]> evs = new ArrayList<>();
        for (int[] event : events) {
            evs.add(new int[]{event[0],0,event[2]});
            evs.add(new int[]{event[1],1,event[2]});
        }
        Collections.sort(evs,(a,b)->{
            if(a[0]==b[0])return a[1]-b[1];
            return a[0]-b[0];
        });
        int ans = 0, bestFirst = 0;
        for (int[] event : evs) {
            if (event[1] == 0) {
                ans = Math.max(ans, event[2] + bestFirst);
            } else {
                bestFirst = Math.max(bestFirst, event[2]);
            }
        }
        return ans;
    }
}
