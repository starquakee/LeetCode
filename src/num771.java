import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class num771 {
    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        Set<Character> jewelsSet = new HashSet<>();
        int jewelsLength = jewels.length();
        for (int i = 0; i < jewelsLength; i++) {
            char jewel = jewels.charAt(i);
            jewelsSet.add(jewel);
        }

        for(char jewel:stones.toCharArray()){
            if(jewelsSet.contains(jewel))ans++;
        }
        return ans;
    }
}
