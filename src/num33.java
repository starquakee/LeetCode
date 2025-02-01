import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class num33 {
//    public int search(int[] nums, int target) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            map.put(nums[i],i);
//        }
//        Arrays.sort(nums);
//        int left = 0;
//        int right = nums.length-1;
//        int mid = 0;
//        while (left<=right){
//            mid = (left+right)/2;
//            if(nums[mid]<target){
//                left = mid+1;
//            }else if(nums[mid]>target){
//                right = mid-1;
//            }else return map.get(nums[mid]);
//        }
//        return -1;
//    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n==1)return nums[0]==target?0:-1;
        int l=0,r=n-1;
        while (l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target)return mid;
            if(nums[0]<=nums[mid]){
                if(nums[0]<=target&&target<=nums[mid]){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }else {
                if(nums[mid]<=target&&target<=nums[n-1]){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}
