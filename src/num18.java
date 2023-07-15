import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num18 {
    public List<List<Integer>> fourSum(int[] nums,int tartget) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i1=0;i1<=n-4;i1++){
            if(i1>0) {
                if(nums[i1]==nums[i1-1]) continue;
            }
            for(int i2=i1+1;i2<=n-3;i2++){
                if(i2>i1+1&&nums[i2]==nums[i2-1]) continue;
                int i4=n-1;
                for(int i3=i2+1;i3<i4;i3++){
                    if(i3>i2+1&&nums[i3]==nums[i3-1]) continue;
                    long sum = (long)nums[i1]+nums[i2]+nums[i3]+nums[i4];
                    while (sum>tartget&&i4>i3){
                        i4--;
                        sum = (long)nums[i1]+nums[i2]+nums[i3]+nums[i4];
                    }
                    if(i4==i3) continue;
                    if(sum==tartget){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i1]);
                        temp.add(nums[i2]);
                        temp.add(nums[i3]);
                        temp.add(nums[i4]);
                        ans.add(temp);
                    }
                }
            }
        }
        return ans;
    }
}
