public class num3411 {
    public int maxLength(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            long prodVal = nums[i];
            long gcdVal = nums[i];
            long lcmVal = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                prodVal = prodVal * nums[j];
                gcdVal = gcd(gcdVal, nums[j]);
                lcmVal = lcmVal * nums[j] / gcd(lcmVal, nums[j]);
                if (prodVal > gcdVal * lcmVal) {
                    break;
                }
                if (prodVal == gcdVal * lcmVal) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
