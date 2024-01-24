import java.util.List;
import java.util.Map;

public class num2865 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long ans = 0;
        long tempAns;
        for(int i=0;i<n;i++){
            int max = maxHeights.get(i);
            tempAns = maxHeights.get(i);
            for(int left=i-1;left>=0;left--){
                max = Math.min(max,maxHeights.get(left));
                tempAns += max;
            }
            max = maxHeights.get(i);
            for(int right=i+1;right<n;right++){
                max = Math.min(max,maxHeights.get(right));
                tempAns += max;
            }
            ans = Math.max(ans,tempAns);
        }
        return ans;
    }
}
