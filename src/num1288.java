import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class num1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int prevEnd = 0;
        Set<String> set = new HashSet<>();
        for (int i=0;i<intervals.length;i++) {
            if (intervals[i][1] <= prevEnd) {
                set.add(Arrays.toString(intervals[i]));
            } else {
                prevEnd = intervals[i][1];
            }
        }
        return intervals.length - set.size();
    }
}
