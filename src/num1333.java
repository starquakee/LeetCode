import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class num1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> list = new ArrayList<>();
        for(int[] restaurant:restaurants){
            if(restaurant[2]>=veganFriendly&&restaurant[3]<=maxPrice&&restaurant[4]<=maxDistance){
                list.add(restaurant);
            }
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1];
                } else return o2[0] - o1[0];
            }
        });
        List<Integer> ans = new ArrayList<>();
        for (int[] ints : list) {
            ans.add(ints[0]);
        }
        return ans;
    }
}
