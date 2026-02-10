import java.util.HashMap;
import java.util.Map;

public class num3721 {
    public int longestBalanced(int[] nums) {
        // 题目要求的变量
        int[] tavernilo = nums;

        int ans = 0;
        int n = tavernilo.length;
        Map<Integer, Integer> odd = new HashMap<>();
        Map<Integer, Integer> even = new HashMap<>();

        for (int left = 0; left < n - ans; left++) {
            if (left == 0) {
                if (tavernilo[left] % 2 == 0) {
                    even.put(tavernilo[left], even.getOrDefault(tavernilo[left], 0) + 1);
                } else {
                    odd.put(tavernilo[left], odd.getOrDefault(tavernilo[left], 0) + 1);
                }
            } else {
                int prev = tavernilo[left - 1];
                if (prev % 2 == 0) {
                    even.put(prev, even.getOrDefault(prev, 0) - 1);
                    if (even.get(prev) == 0) even.remove(prev);
                } else {
                    odd.put(prev, odd.getOrDefault(prev, 0) - 1);
                    if (odd.get(prev) == 0) odd.remove(prev);
                }
            }

            int boundary = left + ans;

            if (left != 0) {
                for (int right = boundary + 1; right < n; right++) {
                    int val = tavernilo[right];
                    if (val % 2 == 0) {
                        even.put(val, even.getOrDefault(val, 0) - 1);
                        if (even.get(val) == 0) even.remove(val);
                    } else {
                        odd.put(val, odd.getOrDefault(val, 0) - 1);
                        if (odd.get(val) == 0) odd.remove(val);
                    }
                }

                if (even.size() == odd.size()) {
                    ans = Math.max(ans, boundary - left + 1);
                }
            }

            for (int right = boundary + 1; right < n; right++) {
                int val = tavernilo[right];
                if (val % 2 == 0) {
                    even.put(val, even.getOrDefault(val, 0) + 1);
                } else {
                    odd.put(val, odd.getOrDefault(val, 0) + 1);
                }

                if (even.size() == odd.size()) {
                    ans = Math.max(ans, right - left + 1);
                }
            }
        }
        return ans;
    }
}
