import java.util.ArrayDeque;
import java.util.Deque;

public class num84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] newHeights = new int[n + 2];
        System.arraycopy(heights, 0, newHeights, 1, n);
        newHeights[0] = 0;
        newHeights[n + 1] = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int ans = 0;
        for (int i = 1; i < newHeights.length; i++) {
            // 当当前柱子高度 < 栈顶柱子高度时，说明栈顶柱子的右边界确定了
            // 此时可以计算以栈顶柱子为高的矩形面积
            while (newHeights[i] < newHeights[stack.peek()]) {
                int curHeight = newHeights[stack.pop()]; // 高度：当前弹出的柱子
                int curWidth = i - stack.peek() - 1;     // 宽度：右边界(i) - 左边界(新栈顶) - 1
                ans = Math.max(ans, curHeight * curWidth);
            }
            stack.push(i);
        }
        return ans;
    }
}
