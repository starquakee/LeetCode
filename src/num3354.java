public class num3354 {
    public int countValidSelections(int[] nums) {
        int n=nums.length;
        int[] leftSum=new int[n];
        int[] rightSum=new int[n];
        for(int i=0;i<n;i++){
            leftSum[i]=nums[i];
            if(i>0) leftSum[i]+=leftSum[i-1];
        }
        for(int i=n-1;i>=0;i--){
            rightSum[i]=nums[i];
            if(i<n-1) rightSum[i]+=rightSum[i+1];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                if(leftSum[i]==rightSum[i]){
                    ans+=2;
                }else if(Math.abs(leftSum[i]-rightSum[i])<=1){ans++;}
            }
        }
        return ans;
    }
}
