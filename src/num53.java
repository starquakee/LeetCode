import java.util.Queue;

public class num53 {
//    public int maxSubArray(int[] nums) {
//        if(nums.length==1)return nums[0];
//        int max = nums[0];
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        for(int i =1;i<nums.length;i++){
//            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
//            max = Math.max(max,dp[i]);
//            System.out.println(max);
//        }
//        return max;
//    }
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int[] preSum=new int[n+1];
        for(int i=1;i<=n;i++){
            preSum[i]=preSum[i-1]+nums[i-1];
        }
        int ans=nums[0];
        int preMin=0;
        for(int i=1;i<=n;i++){
            ans=Math.max(ans,preSum[i]-preMin);
            preMin=Math.min(preMin,preSum[i]);
        }
        return ans;
    }
}
