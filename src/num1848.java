public class num1848 {
    public int getMinDistance(int[] nums, int target, int start) {
        for(int i=0;i<nums.length;i++){
            if(start+i<nums.length&&nums[start+i]==target){
                return i;
            }
            if(start-i>=0&&nums[start-i]==target){
                return i;
            }
        }
        return -1;
    }
}
