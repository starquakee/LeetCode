import java.util.HashSet;
import java.util.Set;

public class num2829 {
    public int minimumSum(int n, int k) {
        int ans=0;
        Set<Integer> set = new HashSet<>();
        for(int i=1;i<=n&&i<k;i++){
            if(!set.contains(k-i)){
                set.add(i);
                ans+=i;
            }
        }
        if(set.size()<n){
            for(int i=k;i<k+n-set.size();i++){
                ans+=i;
            }
        }
        return ans;
    }
}
