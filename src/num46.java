import java.util.ArrayList;
import java.util.List;

public class num46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, tempList, result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                tempList.add(nums[i]);
                used[i] = true;
                backtrack(nums, used, tempList, result);
                used[i] = false;
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        num46 permutations = new num46();
        List<List<Integer>> result = permutations.permute(nums);
        System.out.println(result);
    }
}
