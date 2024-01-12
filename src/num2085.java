import java.util.HashMap;
import java.util.Map;

public class num2085 {
    public int countWords(String[] words1, String[] words2) {
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        int ans = 0;
        for(String word1:words1){
            map1.put(word1,map1.getOrDefault(word1,0)+1);
        }
        for(String word2:words2){
            map2.put(word2,map2.getOrDefault(word2,0)+1);
        }
        for(Map.Entry<String,Integer> entry:map1.entrySet()){
            if(entry.getValue()==1){
                if(map2.getOrDefault(entry.getKey(),0)==1){
                    ans++;
                }
            }
        }
        return ans;
    }
}
