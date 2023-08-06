import java.util.HashSet;
import java.util.Set;

public class num822 {
    public int flipgame(int[] fronts, int[] backs) {
        int ans = 999999;
        for(int i=0;i<fronts.length;i++){
            if(fronts[i]!=backs[i]){
                ans = Math.min(ans,fronts[i]);
                ans = Math.min(ans,backs[i]);
            }
        }
        if(ans!=999999)return ans;
        return 0;
    }
}
