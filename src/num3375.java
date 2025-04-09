import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class num3375 {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums[0]<k)return -1;
        if(Arrays.stream(nums).min().orElse(Integer.MAX_VALUE)<k)return -1;
        return (int) Arrays.stream(nums).filter((x)->x>k).distinct().count();
    }
}
