import java.util.Arrays;

public class num3432 {
    public int countPartitions(int[] nums) {
        int sum= Arrays.stream(nums).sum();
        return sum%2==0?nums.length-1:0;
    }
}
