import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
class node347{
    int val;
    int times;

    public node347(int key, Integer integer) {
        this.val=key;
        this.times=integer;
    }
}
public class num347 {

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<node347> priorityQueue = new PriorityQueue<>((a,b)->b.times-a.times);
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.putIfAbsent(num,0);
            map.put(num,map.get(num)+1);
        }
        for(int key:map.keySet()){
            priorityQueue.offer(new node347(key,map.get(key)));
        }
        int[] ans= new int[k];
        for(int i =0;i<k;i++){
            ans[i] = priorityQueue.poll().val;
        }
        return ans;
    }
}
