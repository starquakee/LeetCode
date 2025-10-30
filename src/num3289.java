import java.util.HashSet;
import java.util.Set;

public class num3289 {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans=new int[2];
        Set<Integer> set=new HashSet<>();
        int i=0;
        for(int num:nums){
            if(set.contains(num)){
                ans[i]=num;
                i++;
            }else set.add(num);
        }
        return ans;
    }
}
