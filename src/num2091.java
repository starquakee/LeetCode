public class num2091 {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int minIndex=0;
        int maxIndex=0;
        for(int i=0;i<n;i++){
            if(nums[i]<min){
                min=nums[i];
                minIndex=i;
            }
            if(nums[i]>max){
                max=nums[i];
                maxIndex=i;
            }
        }
        int left=Math.min(minIndex,maxIndex);
        int right=Math.max(minIndex,maxIndex);
        return Math.min(Math.min(right+1,n-left),left+1+n-right);
    }
}
