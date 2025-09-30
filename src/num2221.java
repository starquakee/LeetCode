public class num2221 {
    public int triangularSum(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                nums[j]=(nums[j+1]+nums[j])%10;
            }
        }
        return nums[0];
    }
}
