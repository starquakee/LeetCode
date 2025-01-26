import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num40 {
    // out of time
//    List<List<Integer>> ans = new ArrayList<>();
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        List<Integer> tempList = new ArrayList<>();
//        backtrack(candidates,target,tempList,0,0);
//        return ans;
//    }
//    private void backtrack(int[] nums, int target, List<Integer> tempList,int begin, int sum) {
//        if (sum == target&&!ans.contains(new ArrayList<>(tempList))) {
//            ans.add(new ArrayList<>(tempList));
//            return;
//        }
//        for(int i=begin;i<nums.length;i++){
//            int sum_new = sum+nums[i];
//            if(sum_new<=target){
//                tempList.add(nums[i]);
//                backtrack(nums,target,tempList,i+1,sum_new);
//                tempList.remove(tempList.size()-1);
//            }else break;
//        }
//    }
    List<int[]> freq = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> sequence = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }
        dfs(0, target);
        return ans;
    }

    public void dfs(int pos, int rest) {
        if (rest == 0) {
            ans.add(new ArrayList<>(sequence));
            return;
        }
        if (pos == freq.size() || rest < freq.get(pos)[0]) {
            return;
        }

        dfs(pos + 1, rest);

        int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= most; ++i) {
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1, rest - i * freq.get(pos)[0]);
        }
        for (int i = 1; i <= most; ++i) {
            sequence.remove(sequence.size() - 1);
        }
    }
}
