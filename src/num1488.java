import java.util.*;

public class num1488 {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans,1);
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> stack = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if(rains[i]==0){
                stack.add(i);
            }else if (!map.containsKey(rains[i])) {
                map.put(rains[i],i);
                ans[i] = -1;
            } else {
                Integer it = stack.ceiling(map.get(rains[i]));
                if(it==null){return new int[0];}
                map.put(rains[i], i);
                ans[it] = rains[i];
                ans[i] = -1;
                stack.remove(it);
            }
        }
        return ans;
    }
}
