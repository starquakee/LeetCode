import java.util.*;

public class num47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        int index=0;
        Arrays.sort(nums);
        backtrack(0,nums,temp,ans,visit);
        return ans;
    }
    public void backtrack(int index, int[] nums, List<Integer> temp, List<List<Integer>> ans, boolean[] visit){
        if(nums.length==index){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visit[i]||(i>0&&nums[i]==nums[i-1]&&!visit[i-1])){
                continue;
            }
            visit[i]=true;
            temp.add(nums[i]);
            backtrack(index+1,nums,temp,ans,visit);
            visit[i]=false;
            temp.remove(index);
        }
    }
}
