import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class num2530 {
    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        Queue<Integer> queue = new PriorityQueue<>((new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        }));
        for(int num:nums){
            queue.add(num);
        }
        for(int i=0;i<k;i++){
            int num = queue.poll();
            ans += num;
            queue.add((num+2)/3);
        }
        return ans;
    }
}
