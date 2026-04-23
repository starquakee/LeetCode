import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class num2615 {
    public long[] distance(int[] nums) {
        long[] ans = new long[nums.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new java.util.ArrayList<>()).add(i);
        }
        for (List<Integer> list : map.values()) {
            long sum = 0;
            for (int i : list) {
                sum += i;
            }
            long pre = 0;
            for (int i = 0; i < list.size(); i++) {
                int idx = list.get(i);
                ans[idx] = (long) idx * i - pre + (sum - pre - idx) - (long) idx * (list.size() - 1 - i);
                pre += idx;
            }
        }
        return ans;
    }
}
