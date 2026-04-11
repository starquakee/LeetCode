import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class num3741 {
    public int minimumDistance(int[] nums) {
        int n=nums.length;
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i], k->new ArrayList<>()).add(i);
        }
        int ans=Integer.MAX_VALUE;
        for(List<Integer> list:map.values()) {
            int m = list.size();
            for (int i = 2; i < m; i++) {
                ans = Math.min(ans, 2 * (list.get(i) - list.get(i - 2)));
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
