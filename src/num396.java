public class num396 {
    public int maxRotateFunction(int[] nums) {
        int sum=0;
        int ans=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int f=0;
        for(int i=0;i<n;i++) {
            f += i * nums[i];
        }
        ans=f;
        for(int i=n-1;i>=0;i--) {
            f = f + sum - n * nums[i];
            ans = Math.max(ans, f);
        }
        return ans;
    }
}
