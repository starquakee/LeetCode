import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class num1705 {
    public int eatenApples(int[] apples, int[] days) {
        int ans = 0;
        Queue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int n = apples.length;
        for(int i=0;i<n;i++){
            pq.offer(new int[]{days[i]+i,apples[i]});
            while (!pq.isEmpty()){
                int[] temp = pq.poll();
                if(temp[0]>i){
                    if(temp[1]>1){
                        pq.offer(new int[]{temp[0],temp[1]-1});
                    }
                    ans++;
                    break;
                }
            }
        }
        for(int i=n;i<50000;i++){
            while (!pq.isEmpty()){
                int[] temp = pq.poll();
                if(temp[0]>i){
                    if(temp[1]>1){
                        pq.offer(new int[]{temp[0],temp[1]-1});
                    }
                    ans++;
                    break;
                }
            }
            if(pq.isEmpty())break;
        }
        return ans;
    }
}
