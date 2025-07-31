import java.util.Arrays;

public class num88 {
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int p1 = m-1;
//        int p2 = n-1;
//        int last = m+n-1;
//        while (p1>=0||p2>=0){
//            if(p1>=0&&p2>=0){
//                if(nums1[p1]>nums2[p2]){
//                    nums1[last] = nums1[p1];
//                    p1--;
//                }else {
//                    nums1[last] = nums2[p2];
//                    p2--;
//                }
//            }else if(p1>=0){
//                nums1[last] = nums1[p1];
//                p1--;
//            }else {
//                nums1[last] = nums2[p2];
//                p2--;
//            }
//            last--;
//        }
//    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0){
            if (n >= 0) System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        if(n==0){
            return;
        }
        int index1=m-1,index2=n-1;
        int putIndex=m+n-1;
        while(index1>=0&&index2>=0){
            if(nums1[index1]>=nums2[index2]){
                nums1[putIndex--]=nums1[index1--];
            }else {
                nums1[putIndex--]=nums2[index2--];
            }
        }
        while (index1<0&&putIndex>=0){
            nums1[putIndex]=nums2[putIndex];
            putIndex--;
        }
    }
}
