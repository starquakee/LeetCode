import java.util.Arrays;

public class num2908 {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Arrays.fill(left,Integer.MAX_VALUE);
        Arrays.fill(right,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            if(i==0){
                left[i] = nums[i];
            }else {
                left[i] = Math.min(left[i-1],nums[i]);
            }
        }
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                right[i] = nums[i];
            }else {
                right[i] = Math.min(right[i+1],nums[i]);
            }
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int ans = Integer.MAX_VALUE;
        for(int i=1;i<n-1;i++){
            if(left[i-1]<nums[i]&&right[i+1]<nums[i]){
                ans = Math.min(ans,left[i-1]+right[i+1]+nums[i]);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
