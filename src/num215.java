import java.util.PriorityQueue;

public class num215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->b-a);
        for(int num:nums){
            priorityQueue.offer(num);
        }
        for(int i=0;i<k-1;i++){
            priorityQueue.poll();
        }
        return priorityQueue.poll();
    }
}
