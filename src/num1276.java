import java.util.ArrayList;
import java.util.List;

public class num1276 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if(tomatoSlices>4*cheeseSlices||tomatoSlices<2*cheeseSlices||tomatoSlices%2==1)return new ArrayList<>();
        int big = (tomatoSlices - 2*cheeseSlices)/2;
        int small = cheeseSlices-big;
        List<Integer> ans = new ArrayList<>();
        ans.add(big);
        ans.add(small);
        return ans;
    }
}
