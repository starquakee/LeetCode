import java.util.ArrayList;
import java.util.List;

public class permutations {
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(nums,ans,tempList);
        return ans;
    }
    public static void backtrack(int[] nums,List<List<Integer>> ans,List<Integer> tempList){
        if(tempList.size()==nums.length){
            ans.add(new ArrayList<>(tempList));
        }else {
            for (int num : nums) {
                if (!tempList.contains(num)) {
                    tempList.add(num);
                    backtrack(nums, ans, tempList);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = permute(nums);
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
