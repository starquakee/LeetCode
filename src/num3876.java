import java.util.Arrays;

public class num3876 {
    public boolean uniformArray(int[] nums1) {
        Arrays.sort(nums1);
        if(nums1[0]%2==0){
            for(int i=1;i<nums1.length;i++){
                if(nums1[i]%2==1){
                    return false;
                }
            }
        }
        return true;
    }
}
