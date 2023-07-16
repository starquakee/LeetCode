import java.util.Arrays;
import java.util.Map;

public class num152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int ans = nums[0];
        int[] dpmax = Arrays.copyOf(nums, n); //以nums【i】结尾的最大乘积；
        int[] dpmin = Arrays.copyOf(nums, n);
        for(int i=1;i<n;i++){
            dpmax[i] = Math.max(dpmax[i],dpmax[i-1]*nums[i]);
            dpmax[i] = Math.max(dpmax[i],dpmin[i-1]*nums[i]);
            dpmin[i] = Math.min(dpmin[i],dpmin[i-1]*nums[i]);
            dpmin[i] = Math.min(dpmin[i],dpmax[i-1]*nums[i]);
            ans = Math.max(ans,dpmax[i]);
        }
        return ans;
    }
}
