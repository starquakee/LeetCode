import java.util.ArrayList;
import java.util.List;

public class num3202 {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int ans=0;
        for(int num:nums){
            for(int i=0;i<k;i++){
                dp[i][num%k]=dp[num%k][i]+1;
                ans=Math.max(ans,dp[i][num%k]);
            }
        }
        return ans;
    }
}
