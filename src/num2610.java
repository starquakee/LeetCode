import java.util.*;

public class num2610 {
    public List<List<Integer>> findMatrix(int[] nums) {
        int max=0;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>[] lists = new ArrayList[nums.length];
        for(int i=0;i<nums.length;i++){
            lists[i] = new ArrayList<>();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            int times=map.getOrDefault(num,0);
            max=Math.max(max,times);
            lists[times].add(num);
            map.put(num,times+1);
        }
        for(int i=0;i<=max;i++){
            ans.add(lists[i]);
        }
        return ans;
    }
}
