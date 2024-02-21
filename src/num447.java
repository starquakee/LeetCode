import java.util.HashMap;
import java.util.Map;

public class num447 {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for(int[] point:points){
            Map<Integer,Integer> map = new HashMap<>();
            for(int[] p:points){
                int distance = (int) (Math.pow(p[0]-point[0],2)+Math.pow(p[1]-point[1],2));
                map.put(distance,map.getOrDefault(distance,0)+1);
            }
            for(Map.Entry<Integer,Integer> entry: map.entrySet()){
                int m = entry.getValue();
                ans += m*(m-1);
            }
        }
        return ans;
    }
}
