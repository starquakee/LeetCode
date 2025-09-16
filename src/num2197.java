import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class num2197 {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            while (!ans.isEmpty()) {
                int last = ans.get(ans.size() - 1);
                int g = gcd(last, num);
                if (g > 1) {
                    num = last / g * num;
                    ans.remove(ans.size() - 1);
                } else {
                    break;
                }
            }
            ans.add(num);
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
