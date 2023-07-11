public class num34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        int ans_left=0;
        int ans_right=0;
        while (left<=right){
            mid = (left+right)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid-1;
            }else {
                ans_left=mid;
                ans_right=mid;
                while (ans_left-1>=0){
                    if(nums[ans_left-1]==target){
                        ans_left--;
                    }else break;
                }
                while (ans_right+1< nums.length){
                    if(nums[ans_right+1]==target){
                        ans_right++;
                    }else break;
                }
                return new int[]{ans_left,ans_right};
            }
        }
        return new int[]{-1,-1};
    }
}
