public class num283 {
    public void moveZeroes(int[] nums) {
        int left=0;
        int zero_num=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero_num++;
            }else {
                nums[left]=nums[i];
                left++;
            }
        }
        for(int i=nums.length-zero_num;i<nums.length;i++){
            nums[i]=0;
        }
    }
}
