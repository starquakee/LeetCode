public class num3355 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diffArray = new int[n+1];
        for(int[] query:queries){
            diffArray[query[0]]++;
            diffArray[query[1]+1]--;
        }
        int[] preSum = new int[n];
        preSum[0]=diffArray[0];
        for(int i=1;i<n;i++){
            preSum[i]=preSum[i-1]+diffArray[i];
        }
        for(int i=0;i<n;i++){
            if(nums[i]-preSum[i]>0)return false;
        }
        return true;
    }
}
