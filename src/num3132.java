import java.util.Arrays;

public class num3132 {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i=2;i>=0;i--){
            int i1=i+1;
            int i2=1;
            while (i1<nums1.length&&i2<nums2.length){
                if(nums1[i1]-nums2[i2]==nums1[i]-nums2[0]){
                    i2++;
                }
                i1++;
            }
            if(i2==nums2.length)return nums2[0]-nums1[i];
        }
        return 0;
    }
}
