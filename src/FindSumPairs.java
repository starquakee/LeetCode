import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {
    Map<Integer, Integer> map1 = new HashMap<>();
    Map<Integer, Integer> map2 = new HashMap<>();
    int[] num1;
    int[] num2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        num1=nums1;
        num2=nums2;
    }

    public void add(int index, int val) {
        num2[index]+=val;
        map2.put(num2[index], map2.getOrDefault(num2[index], 0) + 1);
        map2.put(num2[index]-val, map2.getOrDefault(num2[index]-val, 0) - 1);
    }

    public int count(int tot) {
        int ans=0;
        for(Integer key:map1.keySet()){
            if(map2.containsKey(tot-key)){
                ans+=map1.get(key)*map2.get(tot-key);
            }
        }
        return ans;
    }
}