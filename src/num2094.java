import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class num2094 {
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> ans = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        for(Integer digit:digits){
            map.put((char) (digit+'0'),map.getOrDefault((char) (digit+'0'),0)+1);
        }
        for(int i=100;i<=998;i+=2){
            String s = String.valueOf(i);
            Map<Character,Integer> temp = new HashMap<>();
            temp.put(s.charAt(0),temp.getOrDefault(s.charAt(0),0)+1);
            temp.put(s.charAt(1),temp.getOrDefault(s.charAt(1),0)+1);
            temp.put(s.charAt(2),temp.getOrDefault(s.charAt(2),0)+1);
            boolean b=true;
            for(Character c:temp.keySet()){
                if(map.getOrDefault(c,0)<temp.get(c))b=false;
            }
            if(b)ans.add(i);
        }
        int[] res = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }
}
