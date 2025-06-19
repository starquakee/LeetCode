import java.util.Arrays;

public class num2294 {
    public int partitionArray(int[] nums, int k) {
        int ans=0;
        Arrays.sort(nums);
        int index =0;
        int first=nums[0];
        while (index<nums.length){
            while (index<nums.length&&nums[index]-first<=k){
                index++;
            }
            ans++;
            first=index<nums.length?nums[index]:first;
        }
        return ans;
    }
}
