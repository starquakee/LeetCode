import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class num2799 {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(Integer num:nums)set.add(num);
        int all=set.size();
        int n=nums.length;
        int ans=0;
        int right=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.size()==all){
                right=i;
                ans+=n-i;
                break;
            }
        }
        for(int i=1;i<=n-all;i++){
            map.put(nums[i-1],map.get(nums[i-1])-1);
            if(map.get(nums[i-1])==0)map.remove(nums[i-1]);
            if(map.size()==all){
                ans+=n-right;
            }else {
                for(int j=right+1;j<n;j++){
                    map.put(nums[j],map.getOrDefault(nums[j],0)+1);
                    if(map.size()==all){
                        right=j;
                        ans+=n-j;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
