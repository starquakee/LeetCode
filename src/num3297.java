import java.util.HashMap;
import java.util.Map;

public class num3297 {
    public long validSubstringCount(String word1, String word2) {
        long ans=0;
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(char c:word2.toCharArray()){
            map2.put(c,map2.getOrDefault(c,0)+1);
        }
        int n = word1.length();
        int l=0;
        int r=0;
        map1.put(word1.charAt(0),1);
        for(int i=0;i<n;i++){
            while (r<n){
                if(check(map1,map2)){
                    ans+=n-r;
                    break;
                }
                r++;
                if(r==n)break;
                char c = word1.charAt(r);
                map1.put(c,map1.getOrDefault(c,0)+1);
            }
            map1.put(word1.charAt(i),map1.get(word1.charAt(i))-1);
        }
        return ans;
    }
    public boolean check(Map<Character,Integer> map1, Map<Character,Integer> map2){
        for(char c: map2.keySet()){
            if(map1.getOrDefault(c,0)<map2.get(c))return false;
        }
        return true;
    }
}
