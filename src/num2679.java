import java.util.Arrays;

public class num2679 {
    public int matrixSum(int[][] nums) {
        int res = 0;
        int m = nums.length;
        int n = nums[0].length;
        for (int i = 0; i < m; i++) {
            Arrays.sort(nums[i]);
        }
        for (int j = 0; j < n; j++) {
            int maxVal = 0;
            for (int i = 0; i < m; i++) {
                maxVal = Math.max(maxVal, nums[i][j]);
            }
            res += maxVal;
        }
        return res;
    }
}
