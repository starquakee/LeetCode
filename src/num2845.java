import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class num2845 {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n=nums.size();
        long ans=0L;
        int prefix=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<n;i++){
            int num=nums.get(i)%modulo;
            if(num==k)prefix++;
            ans+=map.getOrDefault((prefix-k+modulo)%modulo,0);
            map.put(prefix%modulo,map.getOrDefault(prefix%modulo,0)+1);
        }
        return ans;
    }
}
