import java.util.HashMap;
import java.util.Map;

public class num2342 {
    public int maximumSum(int[] nums) {
        int ans = -1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            int sum = getSum(num);
            if(!map.containsKey(sum)){
                map.put(sum,num);
            }else {
                ans = Math.max(ans,map.get(sum)+num);
                map.put(sum,Math.max(map.get(sum),num));
            }
        }
        return ans;
    }
    public int getSum(int num){
        int ans = 0;
        while (num>=1){
            ans += num%10;
            num /= 10;
        }
        return ans;
    }
}
