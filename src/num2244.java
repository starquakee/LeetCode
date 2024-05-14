import java.util.HashMap;
import java.util.Map;

public class num2244 {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int task:tasks){
            map.put(task,map.getOrDefault(task,0)+1);
        }
        int ans = 0;
        for(int num:map.values()){
            if (num==1)return -1;
            ans += (num-1)/3+1;
        }
        return ans;
    }
}
