import java.lang.reflect.Array;
import java.util.Arrays;

public class num2369 {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=1;i<=n;i++){
            if(i>=2){
                dp[i] = dp[i-2]&(nums[i-2]==nums[i-1]);
            }
            if(i>=3){
                dp[i] = dp[i]||(dp[i-3]&&nums[i-3]==nums[i-2]&&nums[i-2]==nums[i-1])||(dp[i-3]&&nums[i-3]+1==nums[i-2]&&nums[i-2]+1==nums[i-1]);
            }
        }
        return dp[n];
    }
}
