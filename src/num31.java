import java.util.ArrayList;
import java.util.List;

public class num31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        int j;
        while (i>=0){
            j = i-1;
            while (nums[j]>=nums[i]){
                j--;
                if(j==-1){
                    break;
                }
            }
            if(j>=0){
                swap(nums,i,j);
                reverse(nums,j);
                break;
            }
            i--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
