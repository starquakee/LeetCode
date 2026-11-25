import java.util.HashMap;
import java.util.Map;

public class num3934 {
    public int smallestUniqueSubarray(int[] nums) {
        final long MOD = 1000000007L;
        final long BASE = 911382323L;

        int n = nums.length;
        long[] h = new long[n + 1];
        long[] p = new long[n + 1];
        p[0] = 1;

        // 计算哈希前缀 + BASE 的幂次前缀
        for (int i = 0; i < n; ++i) {
            h[i + 1] = (h[i] * BASE + nums[i]) % MOD;
            p[i + 1] = p[i] * BASE % MOD;
        }

        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(mid, n, h, p, MOD)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private boolean check(int len, int n, long[] h, long[] p, long MOD) {
        Map<Long, Integer> cnt = new HashMap<>();

        for (int l = 0; l + len <= n; ++l) {
            int r = l + len;
            long key = (h[r] - h[l] * p[len] % MOD + MOD) % MOD;
            cnt.merge(key, 1, Integer::sum);
        }

        for (int times : cnt.values()) {
            if (times == 1) {
                return true;
            }
        }
        return false;
    }
}
