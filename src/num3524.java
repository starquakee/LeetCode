public class num3524 {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] result = new long[k];
        long[] dp = new long[k];
        for (int num : nums) {
            long[] ndp = new long[k];
            ndp[num % k]++;
            for (int r = 0; r < k; r++) {
                ndp[(int) (((long) r * num) % k)] += dp[r];
            }
            dp = ndp;
            for (int r = 0; r < k; r++) {
                result[r] += dp[r];
            }
        }

        return result;
    }
}
