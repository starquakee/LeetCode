import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class num3731 {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> missingElements = new java.util.ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff > 1) {
                for (int j = 1; j < diff; j++) {
                    missingElements.add(nums[i - 1] + j);
                }
            }
        }
        return missingElements;
    }
}
