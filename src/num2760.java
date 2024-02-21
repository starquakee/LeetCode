public class num2760 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int left = 0;
        int right = 0;
        int ans = 0;
        while (right<nums.length){
            if(nums[left]%2!=0||nums[left]>threshold){
                left++;
                right++;
                continue;
            }
            right++;
            while (right<nums.length){
                if((nums[right]%2^nums[right-1]%2)==0||nums[right]>threshold){
                    ans = Math.max(ans,right-left);
                    left = right;
                    break;
                }
                right++;
            }
            ans = Math.max(ans,right-left);
        }
        return ans;
    }
}
