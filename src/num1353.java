import java.util.*;

public class num1353 {
    public int maxEvents(int[][] events) {
        int maxEnd=0;
        int ans=0;
        for(int[] e:events){
            maxEnd=Math.max(maxEnd,e[1]);
        }
        List<Integer>[] lists=new ArrayList[maxEnd+1];
        for(int i=0;i<=maxEnd;i++){
            lists[i]=new ArrayList<>();
        }
        for(int[] e:events){
            lists[e[0]].add(e[1]);
        }
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        for(int i=1;i<=maxEnd;i++){
            while (!heap.isEmpty()&&heap.peek()<i){
                heap.poll();
            }
            for(int j=0;j<lists[i].size();j++){
                heap.offer(lists[i].get(j));
            }
            if(!heap.isEmpty()){
                heap.poll();
                ans++;
            }
        }
        return ans;
    }
}
