public class num3379 {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=nums[(i+nums[i]%n+n)%n];
        }
        return ans;
    }
}
