import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        Arrays.sort(nums);
        Arrays.fill(dp,1);
        int maxSize=1;
        int maxNum=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            if(dp[i]>maxSize){
                maxSize=dp[i];
                maxNum=nums[i];
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            if(dp[i]==maxSize&&maxNum%nums[i]==0){
                ans.add(nums[i]);
                maxSize--;
                maxNum=nums[i];
            }
        }
        return ans;
    }
}
