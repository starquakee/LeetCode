import java.util.HashMap;
import java.util.Map;

public class num1590 {
    public int minSubarray(int[] nums, int p) {
        int n=nums.length;
        int[] preSum=new int[n+1];
        int sum=0;
        int ans=Integer.MAX_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            preSum[i]=(preSum[i-1]+nums[i-1])%p;
            sum+=nums[i-1];
            sum%=p;
        }
        if(sum==0)return 0;
        map.put(0,0);
        for(int i=1;i<=n;i++){
            int target=(preSum[i]-sum+p)%p;
            if(map.containsKey(target)&&i-map.get(target)<n){
                ans=Math.min(ans,i-map.get(target));
            }
            if(i<n) map.put(preSum[i],i);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
