public class num1437 {
    public boolean kLengthApart(int[] nums, int k) {
        int pre=-100000;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                if(i-pre<=k)return false;
                pre=i;
            }
        }
        return true;
    }
}
