public class num55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]==0){
                int j = i;
                boolean canCross = false;
                while (j>=0){
                    if(nums[j]+j>i){
                        canCross = true;
                        break;
                    }
                    j--;
                }
                if(!canCross) return false;
            }
        }
        return true;
    }
}
