import java.util.*;

public class num1387 {
    Map<Integer,Integer> map = new HashMap<>();
    public int getKth(int lo, int hi, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i=lo;i<=hi;i++){
            list.add(i);
        }
        list.sort((o1, o2) -> {
            if (weight(o1) == weight(o2)) return o1 - o2;
            return weight(o1) - weight(o2);
        });
        return list.get(k-1);
    }
    public int weight(int num){
        if(num==1)return 0;
        if(map.containsKey(num)){
            return map.get(num);
        }else {
            int weight;
            if(num%2==0)weight=weight(num/2)+1;
            else weight = weight(3*num+1)+1;
            map.put(num, weight);
            return weight;
        }
    }
}
