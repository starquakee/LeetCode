import java.util.Arrays;

public class num213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        int[] v1 = new int[n-1];
        int[] v2 = new int[n-1];
        System.arraycopy(nums,0,v1,0,n-1);
        System.arraycopy(nums,1,v2,0,n-1);
        return Math.max(calculate(v1),calculate(v2));
    }
    public int calculate(int[] nums){
        int n = nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        int[][] dp = new int[n][1+(n+1)/2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[0][1] = nums[0];
        dp[1][1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i][0] = 0;
            for(int j=1;j<=(n+1)/2;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i-2][j-1]+nums[i]);
            }
        }
        int ans = 0;
        for(int i=0;i<=(n+1)/2;i++){
            ans = Math.max(ans,dp[n-1][i]);
        }
        return ans;
    }
}
