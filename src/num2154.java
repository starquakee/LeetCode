import java.util.Arrays;

public class num2154 {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==original){
                original*=2;
            }else if(nums[i]>original){
                return original;
            }
        }
        return original;
    }
}
