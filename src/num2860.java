import java.util.Arrays;
import java.util.List;

public class num2860 {
    public int countWays(List<Integer> nums) {
        int[] a = nums.stream().mapToInt(i -> i).toArray();
        Arrays.sort(a);
        int n = a.length;
        int ans = a[0] > 0 ? 1 : 0; // 一个学生都不选
        for (int i = 0; i < n - 1; i++) {
            if (a[i] < i + 1 && i + 1 < a[i + 1]) {
                ans++;
            }
        }
        return ans + 1; // +1 是因为可以都选
    }
}
