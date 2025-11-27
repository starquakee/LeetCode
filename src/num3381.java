import java.util.Arrays;

public class num3381 {
    public long maxSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long ans=Long.MIN_VALUE;
        long[] postMax=new long[n+1];
        long[] preSum=new long[n+1];
        for(int i=1;i<=n;i++){
            preSum[i]=preSum[i-1]+nums[i-1];
        }
        for(int i=0;i<k;i++){
            for(int j=n-i;j>=0;j-=k){
                if(j+k<=n) {
                    postMax[j]=Math.max(postMax[j+k],preSum[j+k]);
                }else {
                    postMax[j]=preSum[j];
                }
            }
        }
        for(int i=0;i<=n-k;i++){
            ans=Math.max(ans,postMax[i]-preSum[i]);
        }
        return ans;
    }
}
