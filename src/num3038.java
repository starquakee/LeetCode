public class num3038 {
    public int maxOperations(int[] nums) {
        int ans = 0;
        int index = 0;
        if (nums.length < 2) return ans;
        int score = nums[0] + nums[1];
        while (index < nums.length - 1) {
            if (score == nums[index] + nums[index + 1]) {
                ans++;
                index += 2;
            } else return ans;

        }
        return ans;
    }
}
