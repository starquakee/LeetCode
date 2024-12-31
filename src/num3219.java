import java.util.Arrays;

public class num3219 {
    class Solution {
        public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
            Arrays.sort(horizontalCut);
            Arrays.sort(verticalCut);
            int h = 1, v = 1;
            long res = 0;
            int horizontalIndex = horizontalCut.length - 1, verticalIndex = verticalCut.length - 1;
            while (horizontalIndex >= 0 || verticalIndex >= 0) {
                if (verticalIndex < 0 || (horizontalIndex >= 0 && horizontalCut[horizontalIndex] > verticalCut[verticalIndex])) {
                    res += horizontalCut[horizontalIndex--] * h;
                    v++;
                } else {
                    res += verticalCut[verticalIndex--] * v;
                    h++;
                }
            }
            return res;
        }
    }
}
