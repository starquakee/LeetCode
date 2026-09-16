import java.util.Arrays;

public class num1621 {
    private static final int MOD = 1000000007;
    private static final int[][] results = new int[1000][];

    static {
        int[] prefixSums = new int[1001];
        int[] firstRow = new int[1001];
        Arrays.fill(firstRow, 1);
        results[0] = firstRow;
        for (int i = 1; i <= 1000; i++) {
            prefixSums[i] = i;
        }
        for (int i = 1; i < 1000; i++) {
            int[] row = new int[1000 - i];
            results[i] = row;
            int lastNum = 0;
            int sum = 0;
            for (int j = i; j < 1000; j++) {
                int num = (lastNum + prefixSums[j]) % MOD;
                row[j - i] = num;
                sum = (sum + lastNum) % MOD;
                prefixSums[j] = sum;
                lastNum = num;
            }
            prefixSums[1000] = (sum + lastNum) % MOD;
        }
    }

    public int numberOfSets(int n, int k) {
        return results[k][n - 1 - k];
    }
}
