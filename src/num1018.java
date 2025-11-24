import java.util.*;
public class num1018 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int sum=0;
        for(int num:nums){
            sum=(sum*2+num)%5;
            ans.add(sum==0);
        }
        return ans;
    }
}
