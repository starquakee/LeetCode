import java.util.HashSet;
import java.util.Set;

public class num1461 {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < (1 << k) + k - 1) {
            return false;
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }
        return set.size() == (1 << k);
    }
}
