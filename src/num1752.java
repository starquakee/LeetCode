public class num1752 {
    public boolean check(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                for(int j=i+1;j<nums.length-1;j++){
                    if(nums[j]>nums[j+1])return false;
                }
                return nums[nums.length-1]<=nums[0];
            }
        }
        return true;
    }
}
