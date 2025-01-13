public class num2270 {
    // preSum & postSum
//    public int waysToSplitArray(int[] nums) {
//        int ans=0;
//        long[] preSum = new long[nums.length];
//        long[] postSum = new long[nums.length];
//        for(int i=1;i<nums.length;i++){
//            postSum[0]+=nums[i];
//        }
//        preSum[0]=nums[0];
//        if(preSum[0]>=postSum[0])ans++;
//        for(int i=1;i<nums.length-1;i++){
//            preSum[i]=preSum[i-1]+nums[i];
//            postSum[i]=postSum[i-1]-nums[i];
//            if(preSum[i]>=postSum[i])ans++;
//        }
//        return ans;
//    }
    public int waysToSplitArray(int[] nums){
        int ans=0;
        long left=0;
        long right=0;
        for(int num:nums)right+=num;
        for(int i=0;i<nums.length-1;i++){
            left+=nums[i];
            right-=nums[i];
            if(left>=right)ans++;
        }
        return ans;
    }
}
