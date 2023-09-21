import java.lang.reflect.Array;
import java.util.Arrays;

public class num2560 {
    public int minCapability(int[] nums, int k) {
        int low = Arrays.stream(nums).min().getAsInt();
        int high = Arrays.stream(nums).max().getAsInt();
        while (low<=high){
            int mid = (low+high)/2;
            if(check(nums,mid,k)){
                high = mid-1;
            }else low = mid+1;
        }
        return low;
    }
    public boolean check(int[] nums,int y,int k){
        int count = 0;
        boolean isVisited = false;
        for (int num : nums) {
            if (num <= y && !isVisited) {
                count++;
                isVisited = true;
            } else isVisited = false;
        }
        return count>=k;
    }
}
