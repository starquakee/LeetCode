public class num2874 {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        int[] pre=new int[n];
        int[] suf=new int[n];
        for(int i=1;i<n;i++){
            pre[i]=Math.max(pre[i-1],nums[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            suf[i]=Math.max(suf[i+1],nums[i+1]);
        }
        long ans=0;
        for(int i=1;i<n-1;i++){
            int a=pre[i];
            int c=suf[i];
            ans=Math.max(ans, (long) (a-nums[i])*c);
        }
        return ans;
    }
}
