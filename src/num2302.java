public class num2302 {
    public long countSubarrays(int[] nums, long k) {
        int n=nums.length;
        long[] prefix = new long[n+1];
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]+nums[i-1];
        }
        long ans= (long) (n + 1) *n/2;
        int right=0;
        for(int i=0;i<n;i++){
            int len=right-i+1;
            while (right<n&&(prefix[right+1]-prefix[i])*len<k){
                right++;
                len++;
            }
            if(right==n)break;
            ans-=n-right;
        }
        return ans;
    }
}
