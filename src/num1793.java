public class num1793 {
    public int maximumScore(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        int left = k-1;
        int right = k+1;
        for(int i=nums[k];i>=0;){
            while (left>=0&&nums[left]>=i){
                left--;
            }
            while (right<n&&nums[right]>=i){
                right++;
            }
            ans = Math.max(ans, (right-left-1)*i);
            i = Math.max((left == -1 ? -1 : nums[left]), (right == n ? -1 : nums[right]));
        }
        return ans;
    }
}
