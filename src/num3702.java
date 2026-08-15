public class num3702 {
    public int longestSubsequence(int[] nums) {
        int num=nums[0];
        boolean isAllZero=num==0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=0)isAllZero=false;
            num ^= nums[i];
        }
        if(isAllZero)return 0;
        return num==0?nums.length-1:nums.length;
    }
}
