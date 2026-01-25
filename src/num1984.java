import java.util.Arrays;

public class num1984 {
    public int minimumDifference(int[] nums, int k) {
        int ans=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i+k-1<nums.length;i++){
            ans=Math.min(ans,nums[i+k-1]-nums[i]);
        }
        return ans;
    }
}
