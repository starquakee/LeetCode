import java.util.HashSet;
import java.util.Set;

public class num2605 {
    public int minNumber(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int min1 = 999;
        int min2 = 999;
        for(int num:nums1){
            set.add(num);
            min1 = Math.min(min1,num);
        }
        int ans = 99999;
        for(int num:nums2){
            min2 = Math.min(min2,num);
            if(set.contains(num)){
                ans = Math.min(ans,num);
            }
        }
        if(ans<10)return ans;
        if(min1<min2){
            return 10*min1+min2;
        }else {
            return 10*min2+min1;
        }
    }
}
