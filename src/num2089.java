import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num2089 {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target)ans.add(i);
            else if(nums[i]>target)break;
        }
        return ans;
    }
}
