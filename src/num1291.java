import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class num1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new java.util.ArrayList<>();
        for(int i=1;i<=9;i++){
            int num=i;
            for(int j=i+1;j<=9;j++){
                num=num*10+j;
                if(num>=low&&num<=high)ans.add(num);
                if(num>high)break;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
