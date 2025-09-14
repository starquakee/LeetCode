import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class num966 {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] ans = new String[queries.length];
        Map<String,String> map_cap = new HashMap<>();
        Map<String,String> map_vow = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i=wordlist.length-1;i>=0;i--){
            map_cap.put(wordlist[i].toLowerCase(),wordlist[i]);
            set.add(wordlist[i]);
            String newString = wordlist[i].toLowerCase().replace("a","_")
                    .replace("e","_").replace("i","_")
                    .replace("o","_").replace("u","_");
            map_vow.put(newString,wordlist[i]);
        }
        for(int i=0;i<queries.length;i++){
            if(set.contains(queries[i])){
                ans[i] = queries[i];
                continue;
            }
            if(map_cap.containsKey(queries[i].toLowerCase())){
                ans[i] = map_cap.get(queries[i].toLowerCase());
                continue;
            }
            String newString = queries[i].toLowerCase().replace("a","_")
                    .replace("e","_").replace("i","_")
                    .replace("o","_").replace("u","_");
            ans[i] = map_vow.getOrDefault(newString,"");
        }
        return ans;
    }
}
