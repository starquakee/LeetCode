import java.util.Arrays;

public class num1877 {
    public int minPairSum(int[] nums) {
        int ans=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length/2;i++){
            ans=Math.max(ans,nums[i]+nums[nums.length-i-1]);
        }
        return ans;
    }
}
