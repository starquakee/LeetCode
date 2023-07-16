public class num416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n==1) return false;
        int sum = 0;
        int max = 0;
        for(int num:nums){
            sum+=num;
            max = Math.max(max,num);
        }
        if(sum%2==1)return false;
        int target = sum/2;
        if(max>target)return false;
        if(max==target)return true;
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }
}
