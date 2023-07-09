import java.util.HashMap;
import java.util.Map;

public class num167 {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            map.put(numbers[i],i+1);
        }
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(target-numbers[i])){
                return new int[]{i+1,map.get(target-numbers[i])};
            }
        }
        return new int[]{};
    }
}
