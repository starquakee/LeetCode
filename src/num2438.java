import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num2438 {
    public int[] productQueries(int n, int[][] queries) {
        int MOD = 1_000_000_007;
        List<Integer> list = new ArrayList<>();
        int temp=1;
        while (temp<=n){
            if((temp&n)!=0) list.add(temp&n);
            temp=temp<<1;
        }
        int[] arr=list.stream().mapToInt(x->x).toArray();
        long[] ans=new long[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i]=1L;
            for(int j=queries[i][0];j<=queries[i][1];j++){
                ans[i]=ans[i]*arr[j]%MOD;
            }
        }
        return Arrays.stream(ans).mapToInt(l->(int)l).toArray();
    }
}
