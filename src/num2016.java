public class num2016 {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int[] postMax=new int[n];
        postMax[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            postMax[i]=Math.max(nums[i],postMax[i+1]);
        }
        int ans=0;
        for(int i=0;i<n-1;i++){
            ans=Math.max(ans,postMax[i+1]-nums[i]);
        }
        return ans==0?-1:ans;
    }
}
