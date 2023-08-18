import java.util.HashMap;
import java.util.Map;

public class num2682 {
    public int[] circularGameLosers(int n, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        int max = 1;
        int i = 1;
        int cur = 1;
        while (max<2){
            int key = (cur+i*k)%n;
            if(key==0)key = n;
            int new_time = 1+map.getOrDefault(key,0);
            max = Math.max(max, new_time);
            map.put(key,new_time);
            cur = key;
            i++;
        }
        int count = 0;
        for(int j=1;j<=n;j++){
            if(map.get(j)==null){
                count++;
            }
        }
        int[] ans = new int[count];
        count = 0;
        for(int j=1;j<=n;j++){
            if(map.get(j)==null){
                ans[count] = j;
                count++;
            }
        }
        return ans;
    }
}
