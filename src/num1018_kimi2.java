import java.util.ArrayList;
import java.util.List;

public class num1018_kimi2 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int temp=0;
        for(int i=0;i<nums.length;i++){
            temp*=2;
            temp+=nums[i];
            temp%=5;
            if(temp%5==0)ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
}
