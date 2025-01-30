import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num350 {
    // sort and double index
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1=0;
        int index2=0;
        List<Integer> ans = new ArrayList<>();
        while (index1<nums1.length&&index2<nums2.length){
            if(nums1[index1]==nums2[index2]){
                ans.add(nums1[index1]);
                index1++;
                index2++;
            }else if(nums1[index1]>nums2[index2]){
                index2++;
            }else {
                index1++;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
