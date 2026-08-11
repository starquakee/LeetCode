import java.util.HashSet;
import java.util.Set;

public class num2996 {
    public int missingInteger(int[] nums) {
        int n=nums.length;
        int max=0;
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int i=0;
        int sum=nums[i];
        while (i+1<n && nums[i+1]==nums[i]+1){
            sum+=nums[i+1];
            set.add(nums[i+1]);
            i++;
        }
        max=Math.max(max,sum);
        while (true){
            if(!set.contains(max)){
                return max;
            }
            max++;
        }
    }
}
