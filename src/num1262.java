import java.util.*;

public class num1262 {
    public int getSum(List<Integer> list, int size){
        int ans=0;
        for (int i = 0; i < size; i++) {
            ans+=list.get(i);
        }
        return ans;
    }
    public int maxSumDivThree(int[] nums) {
        int ans = 0;
        List<Integer>[] lists = new List[3];
        for (int i = 0; i < 3; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int num : nums) {
            lists[num % 3].add(num);
        }
        for (int i = 0; i < 3; i++) {
            lists[i].sort((a, b) -> b - a);
        }
        for (int i = lists[1].size() - 2; i <= lists[1].size(); i++) {
            if (i >= 0) {
                for (int j = lists[2].size() - 2; j <= lists[2].size(); j++) {
                    if (j >= 0) {
                        if ((i - j) % 3 == 0) {
                            ans = Math.max(ans, getSum(lists[1],i)+getSum(lists[2],j));
                        }
                    }
                }
            }
        }
        return ans+getSum(lists[0],lists[0].size());
    }
}

