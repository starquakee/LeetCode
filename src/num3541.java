import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class num3541 {
    public int maxFreqSum(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int max1 = 0;
        int max2 = 0;
        for (Character c:map.keySet()) {
            if(!set.contains(c)) {
                max1 = Math.max(max1, map.get(c));
            }else  {
                max2 = Math.max(max2, map.get(c));
            }
        }
        return max1 + max2;
    }
}
