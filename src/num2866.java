import java.util.List;

public class num2866 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int max = 0;
        int maxIndex = 0;
        for(int i=0;i<maxHeights.size();i++){
            if(maxHeights.get(i)>max){
                max = maxHeights.get(i);
                maxIndex = i;
            }
        }
        long ans = max;
        int right = max;
        for(int i=maxIndex-1;i>=0;i--){
            if(maxHeights.get(i)<=right){
                ans += maxHeights.get(i);
                right = maxHeights.get(i);
            }else {
                ans += right;
            }
        }
        int left = max;
        for(int i=maxIndex+1;i<maxHeights.size();i++){
            if(maxHeights.get(i)<=left){
                ans += maxHeights.get(i);
                left = maxHeights.get(i);
            }else {
                ans += left;
            }
        }
        return ans;
    }
}
