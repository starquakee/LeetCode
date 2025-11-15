import java.util.*;
import java.util.stream.Collectors;

public class num215 {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue.addAll(collect);
        for(int i=0;i<k-1;i++){
            priorityQueue.poll();
        }
        return priorityQueue.poll();
    }
}
