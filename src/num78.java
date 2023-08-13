import java.util.ArrayList;
import java.util.List;

public class num78 {
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for(int i=0;i<(1<<n);i++){
           int mask = i;
           t.clear();
           for(int j =0;j<n;j++){
               if(((1<<j)&mask)!=0){ //判断第i位是否需要添加数字
                   t.add(nums[j]);
               }
           }
           ans.add(new ArrayList<>(t));
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        num78 permutations = new num78();
        List<List<Integer>> result = permutations.subsets(nums);
        System.out.println(result);
    }
}
