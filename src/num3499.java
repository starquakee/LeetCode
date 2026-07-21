import java.util.ArrayList;
import java.util.List;

public class num3499 {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int originalOnes = 0;
        int maxGain = 0;
        int prevZeroLength = -1;

        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            int length = j - i;

            if (s.charAt(i) == '1') {
                originalOnes += length;
            } else {
                if (prevZeroLength != -1) {
                    maxGain = Math.max(maxGain, prevZeroLength + length);
                }
                prevZeroLength = length;
            }

            i = j;
        }
        return originalOnes + maxGain;
    }
}
