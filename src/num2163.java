import java.util.Collections;
import java.util.PriorityQueue;

public class num2163 {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        long[] preSum=new long[nums.length];
        long[] sufSum=new long[nums.length];
        long leftNSum=0L;
        long rightNSum=0L;
        PriorityQueue<Integer> pqLeft=new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> pqRight=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            leftNSum+=nums[i];
            rightNSum+=nums[nums.length-i-1];
            pqLeft.offer(nums[i]);
            pqRight.offer(nums[nums.length-i-1]);
        }
        preSum[n-1]=leftNSum;
        sufSum[2*n]=rightNSum;
        for(int i=n;i<2*n;i++){
            preSum[i]=preSum[i-1]+nums[i];
            pqLeft.add(nums[i]);
            preSum[i]-=pqLeft.poll();
        }
        for(int i=2*n-1;i>=n;i--){
            sufSum[i]=sufSum[i+1]+nums[i];
            pqRight.add(nums[i]);
            sufSum[i]-=pqRight.poll();
        }
        long ans=Long.MAX_VALUE;
        for(int i=n;i<=2*n;i++){
            ans=Math.min(ans,preSum[i-1]-sufSum[i]);
        }
        return ans;
    }
}
