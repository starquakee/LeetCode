import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class num2913 {
    public int sumCounts(List<Integer> nums) {
        int ans=0;
        int n=nums.size();
        for(int i=0;i<n;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=i;j<n;j++){
                set.add(nums.get(j));
                ans+=set.size()*set.size();
            }
        }
        return ans;
    }
}
