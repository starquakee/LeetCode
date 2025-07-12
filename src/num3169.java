import java.util.Arrays;
import java.util.Comparator;

public class num3169 {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int l=1,r=0;
        for(int[] m:meetings){
            if(m[0]>r){
                days-=(r-l+1);
                l=m[0];
            }
            r=Math.max(r,m[1]);
        }
        days-=(r-l+1);
        return days;
    }
}
