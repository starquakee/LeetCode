import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num39 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> tempList = new ArrayList<>();
        backtrack(candidates,target,tempList,0,0);
        return ans;
    }
    private void backtrack(int[] nums, int target, List<Integer> tempList,int begin, int sum) {
        if (sum == target) {
            ans.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=begin;i<nums.length;i++){
            int sum_new = sum+nums[i];
            if(sum_new<=target){
                tempList.add(nums[i]);
                backtrack(nums,target,tempList,i,sum_new);
                tempList.remove(tempList.size()-1);
            }else break;
        }
    }
}
