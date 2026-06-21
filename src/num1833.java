import java.util.Arrays;

public class num1833 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans=0;
        for(int cost:costs) {
            if (cost > coins) break;
            coins -= cost;
            ans++;
        }
        return ans;
    }
}
