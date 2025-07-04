import java.util.HashMap;
import java.util.Map;

public class num1394 {
    public int findLucky(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans=-1;
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Integer key: map.keySet()){
            if(key==map.get(key)&&key>ans){
                ans=key;
            }
        }
        return ans;
    }
}
