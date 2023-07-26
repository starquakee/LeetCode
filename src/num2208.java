import java.util.Comparator;
import java.util.PriorityQueue;

public class num2208 {
    public int halveArray(int[] nums) {
        int ans = 0;
        double sum = 0;
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>((a,b)->b.compareTo(a));
        for(int num:nums){
            sum += num;
            priorityQueue.offer((double) num);
        }
        double half = sum/2;
        double he = 0.0;
        while (he<half){
            double max = priorityQueue.poll();
            double half_max = max/2;
            he += half_max;
            priorityQueue.offer(half_max);
            ans++;
        }
        return ans;
    }
}
