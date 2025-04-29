public class num2962 {
    public long countSubarrays(int[] nums, int k) {
        int n=nums.length;
        int[] prefix=new int[n+1];
        int maxNum=Integer.MIN_VALUE;
        for(Integer num:nums){
            maxNum=Math.max(maxNum,num);
        }
        long ans=0L;
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1];
            if(nums[i-1]==maxNum)prefix[i]++;
        }
        int right=0;
        for(int i=0;i<n;i++){
            while (right<=n&&prefix[right]-prefix[i]<k){
                right++;
            }
            if(right>n)continue;
            ans+=n-right+1;
        }
        return ans;
    }
}
