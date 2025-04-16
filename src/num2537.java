import java.util.HashMap;
import java.util.Map;

public class num2537 {
    public long countGood(int[] nums, int k) {
        long ans=0L;
        Map<Integer,Integer> map = new HashMap<>();
        int endIndex=0;
        int temp=0;
        for(int i=0;i<nums.length;i++){
            if(i>0){
                map.put(nums[i-1],map.get(nums[i-1])-1);
                temp-=map.get(nums[i-1]);
            }
            while (endIndex<nums.length&&temp<k){
                map.put(nums[endIndex],map.getOrDefault(nums[endIndex],0)+1);
                temp+=map.get(nums[endIndex])-1;
                endIndex++;
            }
            if(temp>=k){
                ans+=nums.length-endIndex+1;
            }
        }
        return ans;
    }
}
