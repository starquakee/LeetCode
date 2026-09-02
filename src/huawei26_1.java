import java.util.Scanner;

public class huawei26_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int batchSize = input.nextInt();
        int seqLen = input.nextInt();
        int dk = input.nextInt();
        int window = input.nextInt();
        double scale = Math.sqrt(dk);

        StringBuilder sb = new StringBuilder();
        for (int b = 0; b < batchSize; b++) {
            double[][] Q = readMatrix(input, seqLen, dk);
            double[][] K = readMatrix(input, seqLen, dk);
            double[][] V = readMatrix(input, seqLen, dk);

            for (int i = 0; i < seqLen; i++) {
                int low = Math.max(0, i - window);
                int high = Math.min(seqLen - 1, i + window);
                int n = high - low + 1;

                double[] scores = new double[n];
                double max = Double.NEGATIVE_INFINITY;
                for (int j = low; j <= high; j++) {
                    double dot = 0;
                    for (int d = 0; d < dk; d++) {
                        dot += Q[i][d] * K[j][d];
                    }
                    scores[j - low] = dot / scale;
                    if (scores[j - low] > max) max = scores[j - low];
                }

                double sum = 0;
                for (int t = 0; t < n; t++) {
                    scores[t] = Math.exp(scores[t] - max);
                    sum += scores[t];
                }

                double[] out = new double[dk];
                for (int j = low; j <= high; j++) {
                    double weight = scores[j - low] / sum;
                    for (int d = 0; d < dk; d++) {
                        out[d] += weight * V[j][d];
                    }
                }

                for (int d = 0; d < dk; d++) {
                    appendNum(sb, out[d]);
                    if (d < dk - 1) sb.append(' ');
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

    private static double[][] readMatrix(Scanner s, int rows, int cols) {
        double[][] m = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m[i][j] = s.nextDouble();
            }
        }
        return m;
    }

    private static void appendNum(StringBuilder sb, double v) {
        long cents = Math.round(v * 100.0);
        if (cents == 0) {
            sb.append("0.00");
            return;
        }
        if (cents < 0) {
            sb.append('-');
            cents = -cents;
        }
        sb.append(cents / 100).append('.');
        long frac = cents % 100;
        if (frac < 10) sb.append('0');
        sb.append(frac);
    }
}
