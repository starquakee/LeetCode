public class num1749 {
//    public int maxAbsoluteSum(int[] nums) {
//        int[] max = new int[nums.length];
//        int[] min = new int[nums.length];
//        max[0] = nums[0];
//        min[0] = nums[0];
//        int ans = Math.abs(nums[0]);
//        for(int i =1;i<nums.length;i++){
//            max[i] = Math.max(max[i-1]+nums[i],nums[i]);
//            min[i] = Math.min(min[i-1]+nums[i],nums[i]);
//            ans = Math.max(ans,Math.abs(max[i]));
//            ans = Math.max(ans,Math.abs(min[i]));
//        }
//        return ans;
//    }
    public int maxAbsoluteSum(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = Math.abs(nums[0]);
        for(int i =1;i<nums.length;i++){
            max = Math.max(max+nums[i],nums[i]);
            min = Math.min(min+nums[i],nums[i]);
            ans = Math.max(ans,Math.abs(max));
            ans = Math.max(ans,Math.abs(min));
        }
        return ans;
    }
}
