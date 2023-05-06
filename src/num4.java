import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class num4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for(int num1:nums1){
            list.add(num1);
        }
        for(int num2:nums2){
            list.add(num2);
        }
        Collections.sort(list);
        System.out.println(list);
        double ans;
        if(list.size()%2==0){
            ans = (double) (list.get((list.size()/2)-1)+list.get((list.size()/2)))/2;
        }else {
            ans = (double) list.get(list.size()/2);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a =new int[]{1,3};
        int[] b =new int[]{2,4};
        System.out.println(findMedianSortedArrays(a,b));
    }
}
