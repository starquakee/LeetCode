public class num1975 {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int count = 0;
        long total = 0;
        int min = Integer.MAX_VALUE;
        for (int[] ints : matrix) {
            for (int j = 0; j < n; ++j) {
                min = Math.min(min, Math.abs(ints[j]));
                if (ints[j] < 0) {
                    count++;
                }
                total += Math.abs(ints[j]);
            }
        }
        if (count % 2 == 0){
            return total;
        } else {
            return total - 2L * min;
        }
    }
}
