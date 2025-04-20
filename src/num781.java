import java.util.HashMap;
import java.util.Map;

public class num781 {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer answer:answers){
            map.put(answer,map.getOrDefault(answer,0)+1);
        }
        int ans=0;
        for(Integer key: map.keySet()){
            int num=(map.get(key)-1)/(key+1);
            ans+=(num+1)*(key+1);
        }
        return ans;
    }
}
