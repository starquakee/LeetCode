public class num3105 {
    public int longestMonotonicSubarray(int[] nums) {
        int cnt1 = 1, cnt2 = 1;
        int ans = 1;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                ans = Math.max(ans, cnt1);
                cnt1 = 1;
            } else {
                cnt1++;
            }
            if (nums[i] >= nums[i - 1]) {
                ans = Math.max(ans, cnt2);
                cnt2 = 1;
            } else {
                cnt2++;
            }
        }
        ans = Math.max(ans, Math.max(cnt1, cnt2));
        return ans;
    }
}
