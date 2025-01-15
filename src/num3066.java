import java.util.PriorityQueue;

public class num3066 {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int num:nums){
            pq.offer((long) num);
        }
        int n = nums.length;
        int ans=0;
        while (ans<n-1&&pq.peek()<k){
            long a = pq.poll();
            long b = pq.poll();
            pq.offer(Math.min(a,b)*2+Math.max(a,b));
            ans++;
        }
        return ans;
    }
}
