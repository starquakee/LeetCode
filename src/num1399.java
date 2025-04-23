import java.util.HashMap;
import java.util.Map;

public class num1399 {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int max=0;
        int ans=0;
        for(int i=1;i<=n;i++){
            int num=i;
            int key=0;
            while (num!=0){
                key+=num%10;
                num/=10;
            }
            map.put(key,map.getOrDefault(key,0)+1);
            max = Math.max(max,map.get(key));
        }
        for(Integer v: map.values()){
            if(v==max)ans++;
        }
        return ans;
    }
}
