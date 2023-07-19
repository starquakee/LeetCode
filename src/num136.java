import java.util.HashMap;
import java.util.Map;

public class num136 {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.remove(num);
            }else {
                map.put(num,1);
            }
        }
        for(int key: map.keySet()){
            return key;
        }
        return 1;
    }
}
