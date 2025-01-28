import java.util.ArrayList;
import java.util.List;

public class num119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        if(rowIndex==0)return ans;
        ans.add(1);
        if (rowIndex==1)return ans;
        for(int i=0;i<rowIndex-1;i++){
            ans.add(1);
            for(int j=0;j<i+1;j++){
                ans.add(ans.get(0)+ans.get(1));
                ans.remove(0);
            }
            ans.add(1);
            ans.remove(0);
        }
        return ans;
    }
}
