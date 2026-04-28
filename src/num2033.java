import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class num2033 {
    public int minOperations(int[][] grid, int x) {
        List<Integer> nums = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        int base = grid[0][0];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((grid[i][j] - base) % x != 0) {
                    return -1;
                }
                nums.add(grid[i][j]);
            }
        }

        Collections.sort(nums);
        int choose = nums.get(nums.size() / 2);
        int ans = 0;
        for (int num : nums) {
            ans += Math.abs(num - choose) / x;
        }
        return ans;
    }
}
