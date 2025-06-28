import java.util.*;

public class num2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> b-a);
        for(int num:nums){
            pq.offer(num);
        }
        int[] ans=new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<k;i++){
            int num=pq.poll();
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int index=0;
        for(int num:nums){
            if(map.getOrDefault(num,0)>0){
                map.put(num, map.getOrDefault(num,0)-1);
                ans[index++]=num;
            }
        }
        return ans;
    }
}
