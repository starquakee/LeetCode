import java.util.Arrays;

public class num3727 {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        long ans=0L;
        for(int i=nums.length/2;i<nums.length;i++){
            ans+=nums[i];
        }
        for(int i=0;i<nums.length/2;i++){
            ans-=nums[i];
        }
        return ans;
    }
}
