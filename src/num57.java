import java.util.ArrayList;
import java.util.List;

public class num57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            int[][] ans = new int[1][2];
            ans[0] = newInterval;
            return ans;
        }
        int left = newInterval[0];
        int right = newInterval[1];
        boolean b = false;
        List<int[]> ansList = new ArrayList<>();
        for (int[] interval : intervals) {
            if(interval[1]<left){
                ansList.add(interval);
            }else if(interval[0]>right){
                if(!b){
                    ansList.add(new int[]{left,right});
                    b = true;
                }
                ansList.add(interval);
            }else {
                left = Math.min(left,interval[0]);
                right = Math.max(right,interval[1]);
            }
        }
        if(!b)ansList.add(new int[]{left,right});
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
