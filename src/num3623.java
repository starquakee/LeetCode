import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class num3623 {
    public int countTrapezoids(int[][] points) {
        int MOD = (int)1e9+7;
        Map<Integer, Long> map = new HashMap<>();
        for(int[] point:points){
            map.put(point[1],map.getOrDefault(point[1],0L)+1);
        }
        long ans=0L;
        Iterator<Map.Entry<Integer, Long>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Long> entry = iterator.next();
            int key=entry.getKey();
            long count=entry.getValue();
            if(count>=2){
                map.put(key, ((long) count *(count-1)/2));
            }else iterator.remove();
        }
        long preSum=0;
        for(Map.Entry<Integer,Long> entry:map.entrySet()){
            long count=entry.getValue();
            ans = (ans+(preSum*count)%MOD)%MOD;
            preSum+=count;
        }
        return (int)ans;
    }
}
