public class num2044 {
    int maxOr = 0;
    int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        for (int num : nums) {
            maxOr |= num;
        }
        dfs(nums, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int index, int currentOr) {
        if (index == nums.length&&currentOr == maxOr) {
            count++;
            return;
        }
        // 不选择 nums[index]
        dfs(nums, index + 1, currentOr);
        // 选择 nums[index]
        dfs(nums, index + 1, currentOr | nums[index]);
    }
}
