import java.util.HashMap;
import java.util.Map;

public class num560 {
//    public int subarraySum(int[] nums, int k) {
//        int count = 0;
//        for(int i=0;i<nums.length;i++){
//            int sum = 0;
//            for(int j=i;j<nums.length;j++){
//                sum += nums[j];
//                if(sum==k) count++;
//            }
//        }
//        return count;
//    }
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int ans=0;
        int[] preSum=new int[n];
        preSum[0]=nums[0];
        Map<Integer,Integer> map=new HashMap<>();
        if(preSum[0]==k)ans++;
        map.put(preSum[0],map.getOrDefault(preSum[0],0)+1);
        for(int i=1;i<n;i++){
            preSum[i]=preSum[i-1]+nums[i];
            if(preSum[i]==k)ans++;
            ans+=map.getOrDefault(preSum[i]-k,0);
            map.put(preSum[i],map.getOrDefault(preSum[i],0)+1);
        }
        return ans;
    }
}
