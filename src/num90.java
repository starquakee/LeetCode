import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num90 {
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<(1<<n);i++){
            t.clear();
            boolean isSkip=false;
            for(int j=0;j<n;j++){
                if(((1<<j)&(i))!=0){
                    if(j>0&&nums[j]==nums[j-1]&&((i>>(j-1)&1)==0)){
                        isSkip=true;
                        break;
                    }
                    t.add(nums[j]);
                }
            }
            if(!isSkip){
                ans.add(new ArrayList<>(t));
            }
        }
        return ans;
    }
}
