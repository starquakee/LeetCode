public class num3783 {
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
