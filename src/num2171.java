import java.lang.reflect.Array;
import java.util.Arrays;

public class num2171 {
    public long minimumRemoval(int[] beans) {
        if(beans.length==1)return 0;
        Arrays.sort(beans);
        long ans = 0;
        for(int i=0;i<beans.length;i++){
            ans += beans[i]-beans[0];
        }
        long preAns = ans;
        for(int i=0;i<beans.length-1;i++){
            long newAns = preAns;
            newAns += beans[i];
            newAns -= (long) (beans[i + 1] - beans[i]) *(beans.length-i-1);
            ans = Math.min(ans,newAns);
            preAns = newAns;
        }
        return ans;
    }
}
