import java.util.*;

public class num49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = Arrays.toString(chars);
            List<String> list = map.getOrDefault(s,new ArrayList<String>());
            list.add(str);
            map.put(s,list);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
