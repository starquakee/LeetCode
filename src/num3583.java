import java.util.HashMap;
import java.util.Map;

public class num3583 {
    public int specialTriplets(int[] nums) {
        Map<Integer,Integer> allMap = new HashMap<>();
        Map<Integer,Integer> tempMap = new HashMap<>();
        int ans=0;
        int MOD = (int) (1e9+7);
        for(int num:nums){
            allMap.put(num,allMap.getOrDefault(num,0)+1);
        }
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int leftCount=tempMap.getOrDefault(num*2,0);
            int rightCount=allMap.getOrDefault(num*2,0);
            if(num==0)rightCount--;
            long temp = (long) leftCount * rightCount%MOD;
            ans= (int) ((ans+temp)%MOD);
            tempMap.put(num,tempMap.getOrDefault(num,0)+1);
            allMap.put(num,allMap.get(num)-1);
        }
        return ans;
    }
}
