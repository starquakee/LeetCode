import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class num3713 {
    public int longestBalanced(String s) {
        int ans=0;
        int n=s.length();
        for(int i=0;i<n;i++) {
            Map<Character, Integer> countMap = new HashMap<>();
            for (int j = i; j < n; j++) {
                countMap.put(s.charAt(j),countMap.getOrDefault(s.charAt(j), 0) + 1);
                if(check(countMap)) ans=Math.max(ans,j-i+1);
            }
        }
        return ans;
    }
    public boolean check(Map<Character, Integer> countMap) {
        int count = 0;
        for (int c : countMap.values()) {
            if(count==0) count=c;
            else if(count!=c) return false;
        }
        return true;
    }
}
