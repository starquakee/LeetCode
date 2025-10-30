public class num560 {
//    public int subarraySum(int[] nums, int k) {
//        int count = 0;
//        for(int i=0;i<nums.length;i++){
//            int sum = 0;
//            for(int j=i;j<nums.length;j++){
//                sum += nums[j];
//                if(sum==k) count++;
//            }
//        }
//        return count;
//    }
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int[] preSum=new int[n];
        preSum[0]=nums[0];
        for(int i=1;i<n;i++){
            preSum[i]=preSum[i-1]+nums[i];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(preSum[i]==k)ans++;
            for(int j=0;j<i;j++){
                if(preSum[i]-preSum[j]==k)ans++;
            }
        }
        return ans;
    }
}
