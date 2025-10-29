import java.util.Arrays;
import java.util.PriorityQueue;

public class num1696 {
    public int maxResult(int[] nums, int k) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0]=nums[0];
        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->b[0]-a[0]);
        queue.add(new int[]{nums[0],0});
        for(int i=1;i<n;i++){
            while (queue.peek()[1]<i-k){
                queue.poll();
            }
            dp[i]=queue.peek()[0]+nums[i];
            queue.add(new int[]{dp[i],i});
        }
        return dp[n-1];
    }
}
