import java.util.Arrays;

public class num3075 {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans=0;
        for(int i=0;i<k;i++){
            ans+=Math.max(0,happiness[happiness.length-1-i]-i);
        }
        return ans;
    }
}
