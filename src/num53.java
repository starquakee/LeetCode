import java.util.Queue;

public class num53 {
    public int maxSubArray(int[] nums) {
        if(nums.length==1)return nums[0];
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i =1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(max,dp[i]);
            System.out.println(max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1,-2};
        num53 num53 = new num53();
        num53.maxSubArray(a);
    }
}
