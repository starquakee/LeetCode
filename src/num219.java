import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class num219 {
//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        int[][] arr = new int[nums.length][2];
//        for (int i=0;i<nums.length;i++){
//            arr[i]=new int[]{nums[i],i};
//        }
//        Arrays.sort(arr,(a,b)-> {
//            if(a[0]==b[0]){
//                return a[1]-b[1];
//            }else return a[0]-b[0];
//        });
//        int index=0;
//        while (index+1<nums.length){
//            if (arr[index][0]==arr[index+1][0]){
//                if(Math.abs(arr[index][1]-arr[index+1][1])<=k)return true;
//            }
//            index++;
//        }
//        return false;
//    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
