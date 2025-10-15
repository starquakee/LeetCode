import java.util.Arrays;
import java.util.List;

public class num3350 {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        if(n==2||n==3)return 1;
        int ans=0;
        int[] increasing = new int[n];
        increasing[0] = 1;
        for (int i = 1; i < n; i++) {
            if(nums.get(i)>nums.get(i-1)){
                increasing[i] = increasing[i-1]+1;
                ans = Math.max(ans,increasing[i]/2);
            }else increasing[i]=1;
        }
        for(int i=1;i<n-1;i++){
            int k=ans;
            while (increasing[i]>=ans&&increasing[i+1]==1&&i+k<n&&k<=increasing[i]&&increasing[i+k]==k){
                ans=Math.max(ans,k);
                k++;
            }
        }
        return ans;
    }
}
