import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

public class num239 {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int[] ans = new int[nums.length-k+1];
//        PriorityQueue<int[]> priorityQueue1 = new PriorityQueue<>((a,b)->a[0]!=b[0]?b[0]-a[0]:b[1]-a[1]);
//        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0]!=o2[0]){
//                    return o2[0]-o1[0];
//                }else {
//                    return o2[1]-o1[1];
//                }
//            }
//        });
//        for(int i=0;i<k;i++){
//            priorityQueue.offer(new int[]{nums[i],i});
//        }
//        assert priorityQueue.peek() != null;
//        ans[0] = priorityQueue.peek()[0];
//        for(int i=k;i<nums.length;i++){
//            priorityQueue.offer(new int[]{nums[i],i});
//            while (priorityQueue.peek()[1]<=i-k){
//                priorityQueue.poll();
//            }
//            ans[i-k+1] = priorityQueue.peek()[0];
//        }
//        return ans;
//    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[0]-a[0]);
        for(int i=0;i<k;i++){
            pq.offer(new int[]{nums[i],i});
        }
        int[] ans = new int[nums.length-k+1];
        ans[0] = pq.peek()[0];
        for(int i=k;i<nums.length;i++){
            pq.offer(new int[]{nums[i],i});
            while (pq.peek()[1]<=i-k){
                pq.poll();
            }
            ans[i-k+1] = pq.peek()[0];
        }
        return ans;
    }
}
