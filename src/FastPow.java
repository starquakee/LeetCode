public class FastPow {
    public static long fastPow(long a, long b, long mod) {
        if (b == 0) return 1 % mod;
        long half = fastPow(a, b / 2, mod);
        long res = (half * half) % mod;
        if (b % 2 == 1) res = (res * a) % mod;
        return res;
    }
}
