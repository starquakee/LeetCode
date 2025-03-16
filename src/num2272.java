import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class num2272 {
    public int largestVariance(String s) {
        Map<Character, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            pos.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(i);
        }

        int ans = 0;
        for (char c0 : pos.keySet()) {
            for (char c1 : pos.keySet()) {
                if (c0 != c1) {
                    List<Integer> pos0 = pos.get(c0);
                    List<Integer> pos1 = pos.get(c1);
                    int i = 0, j = 0;
                    int f = 0, g = Integer.MIN_VALUE;
                    while (i < pos0.size() || j < pos1.size()) {
                        if (j == pos1.size() || (i < pos0.size() && pos0.get(i) < pos1.get(j))) {
                            f = Math.max(f, 0) + 1;
                            g = g + 1;
                            i++;
                        } else {
                            g = Math.max(Math.max(f, g), 0) - 1;
                            f = Math.max(f, 0) - 1;
                            j++;
                        }
                        ans = Math.max(ans, g);
                    }
                }
            }
        }
        return ans;
    }
}
