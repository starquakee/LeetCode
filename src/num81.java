public class num81 {
    public boolean search(int[] nums, int target) {
        if(target==nums[0])return true;
        if(target>nums[0]){
            for(int i=0;i<nums.length;i++){
                if(nums[i]==target)return true;
                if(nums[i]>target||nums[i]<nums[0])return false;
            }
        }else {
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i]==target)return true;
                if(nums[i]<target||nums[i]>nums[0])return false;
            }
        }
        return false;
    }
}
