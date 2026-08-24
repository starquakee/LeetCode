import java.util.HashMap;
import java.util.Map;

public class num3718 {
    public int missingMultiple(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,1);
        }
        for(int i=1;;i++){
            if(!map.containsKey(i*k))return i*k;
        }
    }
}
