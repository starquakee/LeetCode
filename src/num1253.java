import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num1253 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int[] up = new int[colsum.length];
        int[] low = new int[colsum.length];
        List<List<Integer>> ans = new ArrayList<>();
        int cost=0;
        for(int i =0;i<colsum.length;i++){
            int num = colsum[i];
            if(num==2){
                cost++;
                up[i]=1;
                low[i]=1;
            }
        }
        if(cost>upper||cost>lower)return ans;
        for(int i =0;i<colsum.length;i++){
            int num = colsum[i];
            if(num==1){
                if(cost<upper){
                    up[i]=1;
                    upper--;
                }else {
                    if(lower==cost){
                        return ans;
                    }
                    low[i]=1;
                    lower--;
                }
            }
        }
        if(cost!=upper||cost!=lower)return ans;
        List<Integer> list_up = Arrays.asList(Arrays.stream(up).boxed().toArray(Integer[]::new));
        List<Integer> list_low = Arrays.asList(Arrays.stream(low).boxed().toArray(Integer[]::new));
        ans.add(list_up);
        ans.add(list_low);
        return ans;
    }
}
