import java.util.Arrays;
import java.util.Collections;

public class num3095 {
    public int minimumSubarrayLength(int[] nums, int k) {
        Arrays.sort(nums);
        int temp=0;
        for(int i=nums.length-1;i>=0;i--){
            temp = temp|nums[i];
            if(temp>=k)return nums.length-i;
        }
        return -1;
    }
}
