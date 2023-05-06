import java.util.HashMap;
import java.util.Map;

public class num997 {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> map_a = new HashMap<>();
        Map<Integer, Integer> map_b = new HashMap<>();
        for(int i=1;i<=n;i++){
            map_a.put(i,0);
            map_b.put(i,0);
        }
        for(int[] temp : trust){
            map_a.put(temp[0],map_a.get(temp[0])+1);
            map_b.put(temp[1],map_b.get(temp[1])+1);
        }
        for(int i=1;i<=n;i++){
            if(map_a.get(i)==0&&map_b.get(i)==n-1){
                return i;
            }
        }
        return -1;
    }
}
