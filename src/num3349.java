import java.util.Arrays;
import java.util.List;

public class num3349 {
//    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
//        int n = nums.size();
//        if(k==1)return true;
//        for (int i = 0; i+2*k <= n; i++) {
//            for(int j=i+1;j<i+k;j++){
//                if(nums.get(j)<=nums.get(j-1)) break;
//                if(j==i+k-1){
//                    for(int p=i+k+1;p<i+2*k;p++){
//                        if(nums.get(p)<=nums.get(p-1)) break;
//                        if(p==i+2*k-1) return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if(k==1)return true;
        int[] increasing = new int[n];
        increasing[0] = 1;
        for (int i = 1; i < n; i++) {
            if(nums.get(i)>nums.get(i-1)){
                increasing[i] = increasing[i-1]+1;
            }else increasing[i]=1;
        }
        for(int j = 1; j+k < n; j++){
            if(increasing[j]>=k && increasing[j+k]>=k) return true;
        }
        return false;
    }
}
