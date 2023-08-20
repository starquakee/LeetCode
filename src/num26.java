import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class num26 {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int pre = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=pre){
                nums[k] = nums[i];
                k++;
            }
            pre = nums[i];
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(k);
        return k;
    }
}
