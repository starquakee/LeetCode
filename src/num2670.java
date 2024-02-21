import java.util.HashMap;
import java.util.Map;

public class num2670 {
    public int[] distinctDifferenceArray(int[] nums) {
        Map<Integer,Integer> left = new HashMap<>();
        Map<Integer,Integer> right = new HashMap<>();
        int[] ans = new int[nums.length];
        for (int num : nums) {
            right.put(num, right.getOrDefault(num, 0) + 1);
        }
        for(int i=0;i<nums.length;i++){
            left.put(nums[i],left.getOrDefault(nums[i],0)+1);
            right.put(nums[i],right.getOrDefault(nums[i],0)-1);
            if(right.get(nums[i])==0)right.remove(nums[i]);
            ans[i] = left.size()-right.size();
        }
        return ans;
    }
}
