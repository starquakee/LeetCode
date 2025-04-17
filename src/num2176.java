import javafx.util.Pair;

import java.util.*;

public class num2176 {
    public int countPairs(int[] nums, int k) {
        int ans=0;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(nums[i],temp);
            }else {
                for(Integer index:map.get(nums[i])){
                    if(index*i%k==0)ans++;
                }
                List<Integer> temp = map.get(nums[i]);
                temp.add(i);
                map.put(nums[i],temp);
            }
        }
        return ans;
    }
}
