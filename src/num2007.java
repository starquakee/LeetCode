import java.util.*;

public class num2007 {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2==1)return new int[]{};
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(changed);
        Map<Integer,Integer> num_count = new HashMap<>();
        for(int i=0;i<changed.length;i++){
            num_count.put(changed[i],num_count.getOrDefault(changed[i],0)+1);
        }
        int count = 0;
        for(int i=0;i<changed.length;i++){
            if(num_count.getOrDefault(changed[i],0)>0&&num_count.getOrDefault(2*changed[i],0)>0){
                if(changed[i]!=0)count++;
                else if(num_count.get(0)%2==0)count++;
                ans.add(changed[i]);
                num_count.put(changed[i],num_count.get(changed[i])-1);
                num_count.put(2*changed[i],num_count.get(2*changed[i])-1);
            }
        }
        if(count!=changed.length/2)return new int[]{};
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
