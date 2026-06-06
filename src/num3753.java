import java.util.Arrays;

public class num3753 {
    private String s;
    private int n;
    private long[][][] memo_cnt;
    private long[][][] memo_sum;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    // 计算 [0, num] 内所有数字的波动值之和
    private long solve(long num) {
        // 如果少于 3 的数字波动值 0
        if (num < 100) {
            return 0L;
        }
        s = Long.toString(num);
        n = s.length();

        // 记忆化搜索使用两个独立的数组
        // memo_cnt[pos][x][y]：当前位为 pos 位，且前两位为 x, y 的合法填充方案数
        memo_cnt = new long[16][10][10];
        // memo_sum[pos][x][y]：当前位为 pos 位，且左边两位为 x, y 的波动值
        memo_sum = new long[16][10][10];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(memo_cnt[i][j], -1);
                Arrays.fill(memo_sum[i][j], -1);
            }
        }

        long[] result = dfs(0, -1, -1, true, true);
        return result[1];
    }

    private long[] dfs(int pos, int prev, int curr, boolean isLimit, boolean isLeading) {
        // 结束位置
        if (pos == n) {
            return new long[]{1L, 0L};
        }
        // 只有在不受上限限制且不包含前导零时才使用记忆化
        if (!isLimit && !isLeading && prev >= 0 && curr >= 0) {
            if (memo_cnt[pos][prev][curr] != -1) {
                return new long[]{memo_cnt[pos][prev][curr], memo_sum[pos][prev][curr]};
            }
        }

        // 计算当前条件下的方案数和波动值
        long cnt = 0, sum = 0;
        int up = isLimit ? (s.charAt(pos) - '0') : 9;
        for (int digit = 0; digit <= up; ++digit) {
            boolean newLeading = isLeading && (digit == 0);
            // 前一个数字更新为 curr
            int newPrev = curr;
            // 当前数字更新为 digit
            int newCurr = newLeading ? -1 : digit;
            long[] sub = dfs(pos + 1, newPrev, newCurr, isLimit && (digit == up), newLeading);
            long subCnt = sub[0], subSum = sub[1];
            // 不包含前导零时才计算波动值
            if (!newLeading && prev >= 0 && curr >= 0) {
                // 数位为峰或为谷时，更新当前的波动值
                if ((prev < curr && curr > digit) || (prev > curr && curr < digit)) {
                    sum += subCnt;
                }
            }

            cnt += subCnt;
            sum += subSum;
        }

        if (!isLimit && !isLeading && prev >= 0 && curr >= 0) {
            // 更新记忆化数组
            memo_cnt[pos][prev][curr] = cnt;
            memo_sum[pos][prev][curr] = sum;
        }

        return new long[]{cnt, sum};
    }
}
