import java.util.HashSet;
import java.util.Set;

public class num3396 {
//    public int minimumOperations(int[] nums) {
//        int n=nums.length;
//        int res=n%3;
//        if(res==0)res=3;
//        int ans=(n-1)/3+1;
//        Set<Integer> set = new HashSet<>();
//        for(int i=n-1;i>n-1-res;i--){
//            if(set.contains(nums[i]))return ans;
//            set.add(nums[i]);
//        }
//        for(int i=0;i<ans-1;i++){
//            for(int j=1;j<=3;j++){
//                int num=nums[n-j-res-3*i];
//                if(set.contains(num))return ans-i-1;
//                set.add(num);
//            }
//        }
//        return 0;
//    }
    public int minimumOperations(int[] nums) {
        int n=nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=n-1;i>=0;i--){
            if(set.contains(nums[i]))return i/3+1;
            set.add(nums[i]);
        }
        return 0;
    }
}
