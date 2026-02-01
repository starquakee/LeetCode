import java.util.PriorityQueue;

public class num3010 {
    public int minimumCost(int[] nums) {
        int ans=nums[0];
        PriorityQueue pq = new PriorityQueue();
        for(int i=1;i<nums.length;i++){
            pq.add(nums[i]);
        }
        ans+= (int)pq.poll();
        ans+= (int)pq.poll();
        return ans;
    }
}
