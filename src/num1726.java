import java.util.HashMap;
import java.util.Map;

public class num1726 {
    public int tupleSameProduct(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int pre = map.getOrDefault(nums[i]*nums[j],0);
                map.put(nums[i]*nums[j],pre+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int value = entry.getValue();
            if(value>1){
                ans += (value -1)* value/2;
            }
        }
        return ans*8;
    }
}

