public class Sqrt2Solver {
    public static double sqrt2BinarySearch(double precision) {
        double low = 1.0;
        double high = 2.0;
        double mid = low + (high - low) / 2.0;

        while ((high - low) > precision) {
            double square = mid * mid;

            if (square > 2.0) {
                high = mid;
            } else if (square < 2.0) {
                low = mid;
            } else {
                return mid;
            }

            mid = low + (high - low) / 2.0;
        }
        return mid;
    }

    public static void main(String[] args) {
        double precision = 1e-9;
        double result = sqrt2BinarySearch(precision);
        System.out.println("使用二分法计算 根号二: " + result);
    }
}