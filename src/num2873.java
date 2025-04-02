public class num2873 {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        long ans=0;
        for(int i=0;i<=n-3;i++){
            for(int j=i+1;j<=n-2;j++){
                for(int k=j+1;k<=n-1;k++){
                    ans=Math.max(ans, (long) (nums[i] - nums[j]) *nums[k]);
                }
            }
        }
        return ans;
    }
}
