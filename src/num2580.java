import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num2580 {
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges,(a,b)->a[0]-b[0]);
        int n = ranges.length;
        int ans = 1;
        int mod = (int) (1e9+7);
        int count = 0;
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int left = ranges[i][0];
            int right = ranges[i][1];
            if(list.isEmpty()){
                list.add(new int[]{left,right});
            }else if(list.get(list.size()-1)[1]>=left){
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], right);
            }else {
                list.add(new int[]{left,right});
            }
        }
        for(int i=0;i<list.size();i++){
            ans = (int) ((long) ans * 2)%mod;
        }
        return ans;
    }
}
