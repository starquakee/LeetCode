public class num2348 {
    public long zeroFilledSubarray(int[] nums) {
        long ans=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            while (i<nums.length&&nums[i]==0){
                count++;
                i++;
            }
            if(count>0){
                ans+=cal(count);
            }
            count=0;
        }
        return ans;
    }
    public long cal(int num){
        long ans=0;
        ans= (long) (1 + num) *num/2;
        return ans;
    }
}
