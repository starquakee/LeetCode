import java.util.Arrays;

public class num1979 {
    public int findGCD(int[] nums) {
        return gcd(Arrays.stream(nums).min().getAsInt(), Arrays.stream(nums).max().getAsInt());
    }
    public int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
}
