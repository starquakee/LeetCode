import java.util.Arrays;

public class num3397 {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans=1;
        nums[0]-=k;
        for (int i = 1; i < n; i++) {
            nums[i]=Math.min(Math.max(nums[i]-k,nums[i-1]+1),nums[i]+k);
            if(nums[i]>nums[i-1]) ans++;
        }
        return ans;
    }
}
