import java.util.Arrays;
import java.util.Comparator;

public class num1727 {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            matrix[i] = Arrays.stream(matrix[i]).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, (j + 1) * matrix[i][j]);
            }
        }
        return maxArea;
    }
}
