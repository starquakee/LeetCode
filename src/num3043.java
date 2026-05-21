import java.util.HashSet;
import java.util.Set;

public class num3043 {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : arr1) {
            while (num>0) {
                set1.add(num);
                num /= 10;
            }
        }
        int longestPrefix = 0;
        for (int num : arr2) {
            while (num > 0) {
                if (set1.contains(num)) {
                    longestPrefix = Math.max(longestPrefix, String.valueOf(num).length());
                    break;
                } else {
                    num /= 10;
                }
            }
        }
        return longestPrefix;
    }
}
