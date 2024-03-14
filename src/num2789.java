import java.util.Arrays;

public class num2789 {
    public long maxArrayValue(int[] nums) {
        long ans = nums[nums.length-1];
        long[] nums_long = new long[nums.length];
        for(int i=0;i<nums.length;i++){
            nums_long[i] = nums[i];
        }
        int i = nums.length-1;
        while (i>=1){
            while (i>=1&&nums_long[i]>=nums_long[i-1]){
                nums_long[i-1] += nums_long[i];
                i--;
            }
            ans = Math.max(ans, nums_long[i]);
            i--;
        }
        ans = Math.max(ans, nums_long[0]);
        return ans;
    }
}
