public class num3637 {
    public boolean isTrionic(int[] nums) {
        boolean b1=false;
        boolean b2=false;
        int i=1;
        while (nums[i]>nums[i-1]){
            i++;
            b1=true;
            if(i>=nums.length)return false;
        }
        while (b1&&nums[i]<nums[i-1]){
            i++;
            b2=true;
            if(i>=nums.length)return false;
        }
        while (b1&&b2&&nums[i]>nums[i-1]) {
            i++;
            if (i >= nums.length) return true;
        }
        return false;
    }
}
