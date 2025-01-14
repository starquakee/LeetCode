import java.util.Arrays;

public class num3065 {
    public int minOperations(int[] nums, int k) {
        return (int) Arrays.stream(nums).filter(num -> num < k).count();
    }
}
