import java.util.Arrays;

public class num1561 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans=0;
        int n=piles.length/3;
        for(int i=n;i<3*n;i+=2){
            ans+=piles[i];
        }
        return ans;
    }
}
