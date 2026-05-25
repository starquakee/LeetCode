import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class num3120 {
    public int numberOfSpecialChars(String word) {
        Set<Character> s = new HashSet<>();
        for (char c : word.toCharArray()) {
            s.add(c);
        }
        int ans = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (s.contains(c) && s.contains((char)(c - 'a' + 'A'))) {
                ans++;
            }
        }
        return ans;
    }
}
