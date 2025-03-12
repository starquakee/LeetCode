import java.util.HashMap;
import java.util.Map;

public class num3305 {
    public int countOfSubstrings(String word, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int n = word.length();
        int minLen = k + 5;
        for (int i = 0; i + minLen <= n; i++) {
            map.clear();
            for (int j = i; j < n; j++) {
                boolean isBreak=false;
                char c = word.charAt(j);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                } else map.put('z', map.getOrDefault('z', 0) + 1);
                if (map.getOrDefault('z', 0) > k) break;
                if (map.getOrDefault('a', 0) >= 1 && map.getOrDefault('e', 0) >= 1
                        && map.getOrDefault('i', 0) >= 1 && map.getOrDefault('o', 0) >= 1
                        && map.getOrDefault('u', 0) >= 1) {
                    if(map.getOrDefault('z',0)==k){
                        ans++;
                    }
                    while (j+1<n){
                        j++;
                        char cc=word.charAt(j);
                        if (cc != 'a' && cc != 'e' && cc != 'i' && cc != 'o' && cc != 'u') {
                            map.put('z', map.getOrDefault('z', 0) + 1);
                            if(map.getOrDefault('z',0)==k){
                                ans++;
                            }else if(map.getOrDefault('z',0)>k){
                                isBreak=true;
                                break;
                            }
                        }else if(map.getOrDefault('z',0)==k)ans++;
                    }
                }
                if(isBreak)break;
            }
        }
        return ans;
    }
}
