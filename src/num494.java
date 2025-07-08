import java.util.Arrays;

public class num494 {
//    public int findTargetSumWays(int[] nums, int target) {
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        int diff = sum - target;
//        if (diff < 0 || diff % 2 != 0) {
//            return 0;
//        }
//        int n = nums.length;
//        int[][] dp = new int[n+1][diff/2+1];
//        dp[0][0] = 1;
//        for(int i=1;i<=n;i++){
//            for(int j =0;j<=diff/2;j++){
//                if(j-nums[i-1]>=0){
//                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
//                }else dp[i][j] = dp[i-1][j];
//            }
//        }
//        return dp[n][diff/2];
//    }
    private int count=0;
    public int findTargetSumWays(int[] nums, int target){
        backtrack(0,0,target,nums);
        return count;
    }
    public void backtrack(int index,int sum,int target,int[] nums){
        if(index==nums.length&&sum==target){
            count++;
            return;
        }
        if(index==nums.length)return;
        backtrack(index+1,sum+nums[index],target,nums);
        backtrack(index+1,sum-nums[index],target,nums);
    }
}
