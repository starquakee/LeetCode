import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class num2808 {
    public int minimumSeconds(List<Integer> nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.size();
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int num = entry.getKey();
            boolean[] b = new boolean[n];
            int full = entry.getValue();
            for(int i=0;i<n; i++){
                if(nums.get(i)==num){
                    b[i] = true;
                }
            }
            int time = 0;
            while (full<n){
                full = 0;
                time++;
                for(int i=0;i<n;i++){
                    if(b[i]){
                        full++;
                        if(!b[(i-1+n)%n]&&!b[(i-2+n)%n]){
                            full++;
                        }
                        if(!b[(i+1+n)%n]){
                            full++;
                        }
                    }
                }
                boolean[] newB = new boolean[n];
                System.arraycopy(b, 0, newB, 0, n);
                for(int i=0;i<n;i++){
                    if(b[i]){
                        if(!b[(i-1+n)%n]){
                            newB[(i-1+n)%n] = true;
                        }
                        if(!b[(i+1+n)%n]){
                            newB[(i+1+n)%n] = true;
                        }
                    }
                }
                System.arraycopy(newB, 0, b, 0, n);
            }
            if(time == 1)System.out.println(num);
            ans = Math.min(ans,time);
        }
        return ans;
    }
}
