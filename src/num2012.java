public class num2012 {
    public int sumOfBeauties(int[] nums) {
        int ans=0;
        int n=nums.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        post[n-1]=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            pre[i] = Math.max(pre[i-1],nums[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            post[i] = Math.min(post[i+1],nums[i+1]);
        }
        for(int i=1;i<=n-2;i++){
            if(nums[i]>pre[i]&&nums[i]<post[i]){
                ans+=2;
            }else if(nums[i]>nums[i-1]&&nums[i]<nums[i+1]){
                ans++;
            }
        }
        return ans;
    }
}
