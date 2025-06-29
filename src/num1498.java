import java.util.Arrays;

public class num1498 {
    public int numSubseq(int[] nums, int target) {
        int MOD= (int) (1e9+7);
        long ans=0L;
        int n=nums.length;
        int[] pow2 = new int[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }
        Arrays.sort(nums);
        int left=0;
        int right=n-1;
        while (left<=right){
            if(nums[left]+nums[right]<=target){
                long newNum = pow2[right-left];
                ans = (ans+newNum)%MOD;
            }else {
                while (left<right){
                    right--;
                    if(nums[left]+nums[right]<=target){
                        long newNum = pow2[right-left];
                        ans = (ans+newNum)%MOD;
                        break;
                    }
                }
            }
            left++;
        }
        return (int) ans;
    }
}
