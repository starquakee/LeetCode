import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class num756 {
    //pass
    int[][] T;
    Set<Long> seen;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        T = new int[7][7];
        // 构建转换表，T[i][j] 表示底部为i和j时，顶部可能的字符位掩码
        for (String a : allowed) {
            int left = a.charAt(0) - 'A';
            int right = a.charAt(1) - 'A';
            int top = a.charAt(2) - 'A';
            T[left][right] |= 1 << top;
        }

        seen = new HashSet<>();
        int N = bottom.length();
        int[][] A = new int[N][N];  // 金字塔状态数组
        int t = 0;
        // 初始化底部行
        for (char c : bottom.toCharArray()) {
            A[N - 1][t++] = c - 'A';
        }
        return solve(A, 0, N - 1, 0);
    }
    public boolean solve(int[][] A, long R, int N, int i) {
        // 基本情况：成功构建到金字塔顶部
        if (N == 1 && i == 1) {
            return true;
        } else if (i == N) { // 当前行处理完成，准备处理下一行
            // 记忆化检查：如果已经处理过相同的行状态，直接返回失败
            if (seen.contains(R)) {
                return false;
            }
            // 记录当前行状态
            seen.add(R);
            // 递归处理下一行
            return solve(A, 0, N - 1, 0);
        } else { // 处理当前行的当前位置
            // 获取当前两个底部块对应的可能顶部块位掩码
            int w = T[A[N][i]][A[N][i + 1]];
            // 遍历所有可能的顶部块
            for (int b = 0; b < 7; ++b) {
                if (((w >> b) & 1) != 0) {
                    // 设置顶部块
                    A[N - 1][i] = b;
                    // 递归处理下一个位置，更新状态编码
                    // 使用base-8编码来记录当前行的状态
                    if (solve(A, R * 8 + (b + 1), N, i + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
