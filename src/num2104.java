public class num2104 {
    //copied
    private char[] ans;
    private int ansLen = 0;

    public String longestSubsequenceRepeatedK(String S, int k) {
        char[] s = S.toCharArray();

        int[] cnt = new int[26];
        for (char c : s) {
            cnt[c - 'a']++;
        }

        StringBuilder tmp = new StringBuilder();
        // 倒序，这样我们可以优先枚举字典序大的排列
        for (int i = 25; i >= 0; i--) {
            String c = String.valueOf((char) ('a' + i));
            for(int j=0;j<cnt[i] / k;j++){
                tmp.append(c);
            }
//            tmp.append(c.repeat(cnt[i] / k));
        }
        char[] a = tmp.toString().toCharArray();

        ans = new char[a.length];
        permute(a, k, s);

        return new String(ans, 0, ansLen);
    }

    // 47. 全排列 II
    // 枚举从 nums 中选任意个数的所有排列，处理枚举的排列
    private void permute(char[] nums, int k, char[] s) {
        int n = nums.length;
        char[] path = new char[n];
        boolean[] onPath = new boolean[n]; // onPath[j] 表示 nums[j] 是否已经填入排列
        dfs(0, nums, path, onPath, k, s);
    }

    private void dfs(int i, char[] nums, char[] path, boolean[] onPath, int k, char[] s) {
        // 处理当前排列 path
        process(path, i, k, s);

        if (i == nums.length) {
            return;
        }

        // 枚举 nums[j] 填入 path[pathLen]
        for (int j = 0; j < nums.length; j++) {
            // 如果 nums[j] 已填入排列，continue
            // 如果 nums[j] 和前一个数 nums[j-1] 相等，且 nums[j-1] 没填入排列，continue
            if (onPath[j] || j > 0 && nums[j] == nums[j - 1] && !onPath[j - 1]) {
                continue;
            }
            path[i] = nums[j]; // 填入排列
            onPath[j] = true; // nums[j] 已填入排列（注意标记的是下标，不是值）
            dfs(i + 1, nums, path, onPath, k, s); // 填排列的下一个数
            onPath[j] = false; // 恢复现场
            // 注意 path 无需恢复现场，直接覆盖 path[i] 就行
        }
    }

    private void process(char[] seq, int seqLen, int k, char[] s) {
        // 先比大小（时间复杂度低），再判断是否为子序列（时间复杂度高）
        if (seqLen > ansLen || seqLen == ansLen && compare(seq, ans, ansLen) > 0) {
            if (isSubsequence(seq, seqLen, k, s)) {
                System.arraycopy(seq, 0, ans, 0, seqLen);
                ansLen = seqLen;
            }
        }
    }

    // 比较 a 和 b 的字典序大小
    private int compare(char[] a, char[] b, int n) {
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                return a[i] - b[i];
            }
        }
        return 0;
    }

    // 392. 判断子序列
    // 返回 seq*k 是否为 s 的子序列
    private boolean isSubsequence(char[] seq, int n, int k, char[] s) {
        int i = 0;
        for (char c : s) {
            if (seq[i % n] == c) {
                i++;
                if (i == n * k) { // seq*k 的所有字符匹配完毕
                    return true; // seq*k 是 s 的子序列
                }
            }
        }
        return false;
    }
}
