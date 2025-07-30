import java.util.Arrays;

public class num2419 {
    public int longestSubarray(int[] nums) {
        int max= Arrays.stream(nums).max().getAsInt();
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int temp=0;
            while (i<nums.length&&nums[i]==max){
                temp++;
                i++;
            }
            ans=Math.max(ans,temp);
        }
        return ans;
    }
}
