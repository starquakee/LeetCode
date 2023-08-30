import java.util.ArrayList;
import java.util.List;

public class num228 {
    public List<String> summaryRanges(int[] nums) {
        int left = 0;
        int right = 1;
        List<String> ans = new ArrayList<>();
        if(nums.length==1) {
            ans.add(String.valueOf(nums[0]));
            return ans;
        }
        while (right<nums.length){
            if(nums[right]-nums[right-1]==1){
                right++;
            }else {
                if(left!=right-1){
                    ans.add(nums[left]+"->"+nums[right-1]);

                }else {
                    ans.add(String.valueOf(nums[left]));
                }
                left = right;
                if(left==nums.length-1){
                    ans.add(String.valueOf(nums[left]));
                }
                right++;
            }
        }
        if(left!=right-1){
            ans.add(nums[left]+"->"+nums[right-1]);

        }
        return ans;
    }
}
