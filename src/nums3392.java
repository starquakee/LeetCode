public class nums3392 {
    public int countSubarrays(int[] nums) {
        int ans=0;
        for(int i=0;i+2<nums.length;i++){
            if(nums[i+1]==(nums[i]+nums[i+2])*2)ans++;
        }
        return ans;
    }
}
