import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class num594 {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int ans=0;
        for(Integer key:map.keySet()){
            if(map.containsKey(key+1)){
                ans=Math.max(ans, map.get(key)+ map.get(key+1));
            }
        }
        return ans;
    }
}
