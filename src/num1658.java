import java.util.HashMap;
import java.util.Map;

public class num1658 {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        int[] preSum=new int[n];
        int[] postSum=new int[n];
        Map<Integer, Integer> pre=new HashMap<>();
        Map<Integer,Integer> post = new HashMap<>();
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            pre.put(sum,i);
        }
        sum=0;
        for(int i=n-1;i>=0;i--){
            sum+=nums[i];
            post.put(sum,i);
        }
        post.put(0,n);
        int ans=Integer.MAX_VALUE;
        if(post.containsKey(x))ans=n-post.get(x);
        sum=0;
        for(int i=0;i<n&&sum<=x;i++){
            sum+=nums[i];
            if(post.containsKey(x-sum)&&i+1+n-post.get(x-sum)<=n){
                ans=Math.min(ans,i+1+n-post.get(x-sum));
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
