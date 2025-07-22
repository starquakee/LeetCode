import java.util.HashMap;
import java.util.Map;

public class num1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int l=0,r=1;
        int ans=nums[0];
        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],1);
        int temp=nums[0];
        while (r<nums.length){
            if(!map.containsKey(nums[r])){
                map.put(nums[r],1);
                temp+=nums[r];
                ans=Math.max(ans,temp);
                r++;
            }else {
                while (l<=r&&nums[l]!=nums[r]){
                    temp-=nums[l];
                    map.remove(nums[l]);
                    l++;
                }
                l++;
                r++;
            }
        }
        return ans;
    }
}
