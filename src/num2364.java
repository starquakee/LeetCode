import java.util.HashMap;
import java.util.Map;

public class num2364 {
    public long countBadPairs(int[] nums) {
        int n=nums.length;
        long ans= (long) n *(n-1)/2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int x=nums[i]-i;
            if(map.containsKey(x)){
                int temp=map.get(x);
                ans-=temp;
                map.put(x,temp+1);
            }else {
                map.put(x,1);
            }
        }
        return ans;
    }
}
