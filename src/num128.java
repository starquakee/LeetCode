import java.util.HashMap;
import java.util.Map;

public class num128 {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for(int num : nums){
            map.put(num,true);
        }
        for(Integer key: map.keySet()){
            int count = 0;
            if(!map.containsKey(key-1)){
                while (map.containsKey(key)){
                    key++;
                    count++;
                }
                max = Math.max(max,count);
            }
        }
        return max;
    }
}
