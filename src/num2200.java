import java.util.*;

public class num2200 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> keyIndex=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==key){
                keyIndex.add(i);
            }
        }
        Set<Integer> set = new HashSet<>();
        for(Integer keyIdx:keyIndex){
            for(int i=keyIdx-k;i<=keyIdx+k;i++){
                if(i>=0&&i<nums.length) set.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
}
