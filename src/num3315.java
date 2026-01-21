import java.util.List;

public class num3315 {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            if (x == 2) {
                ans[i] = -1;
            } else {
                int t = ~x;
                int lowbit = t & -t;
                ans[i] = x ^ (lowbit >> 1);
            }
        }
        return ans;
    }
}
