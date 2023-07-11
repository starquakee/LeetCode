import java.util.Arrays;
import java.util.PriorityQueue;

public class num153 {
    public int findMin(int[] nums) {
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1])return nums[i];
        }
        return nums[0];
    }
}
