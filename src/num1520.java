import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class num1520 {
    public List<String> maxNumOfSubstrings(String s) {
        // 记录每个字符的第一次和最后一次出现位置
        Map<Character, int[]> pos = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!pos.containsKey(ch)) {
                pos.put(ch, new int[]{i, i});
            } else {
                pos.get(ch)[1] = i;
            }
        }

        // 所有合法的区间
        List<int[]> valid = new ArrayList<>();

        for (Map.Entry<Character, int[]> entry : pos.entrySet()) {
            int[] range = entry.getValue();
            int l = range[0], r = range[1];
            int nl = l, nr = l;

            while (nl >= l || nr <= r) {
                int i = (nl >= l) ? nl : nr;

                // 当前处理的是字符 s[i]
                int[] currentRange = pos.get(s.charAt(i));
                int l_t = currentRange[0];
                int r_t = currentRange[1];

                // 当前区间左侧还有该字符，需要向左扩展
                if (l_t < l) {
                    l = l_t;
                }

                // 当前区间右侧还有该字符，需要向右扩展
                if (r_t > r) {
                    r = r_t;
                }

                // 当前处理的是左指针
                if (i == nl) {
                    nl--;
                }

                // 当前处理的是右指针
                if (i == nr) {
                    nr++;
                }
            }

            valid.add(new int[]{l, r});
        }

        // 按右端点升序排序
        valid.sort((a, b) -> a[1] - b[1]);

        // 贪心选择互不重叠的区间
        List<String> ans = new ArrayList<>();
        int end = -1;

        for (int[] interval : valid) {
            int left = interval[0];
            int right = interval[1];

            if (left > end) {
                ans.add(s.substring(left, right + 1));
                end = right;
            }
        }

        return ans;
    }
}
