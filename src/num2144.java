import java.util.Arrays;

public class num2144 {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n=cost.length;
        int sum=0;
        for(int i=n-1;i>=0;i-=3) {
            sum += cost[i];
            if (i - 1 >= 0) {
                sum += cost[i - 1];
            }
        }
        return sum;
    }
}
