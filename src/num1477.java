import java.util.HashMap;
import java.util.Map;

public class num1477 {
    public int minSumOfLengths(int[] arr, int target) {
        int preSum=0;
        int min1=Integer.MAX_VALUE-1;
        int min2=Integer.MAX_VALUE;
        int n=arr.length;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0, -1);
        for(int i=0;i<n;i++){
            preSum+=arr[i];
            if(map.containsKey(preSum-target)){
                if(i-map.get(preSum-target)<=min1){
                    min2=min1;
                    min1=i-map.get(preSum-target);
                }else if(i-map.get(preSum-target)<min2)min2=i-map.get(preSum-target);
            }
            map.put(preSum,i);
        }
        if(min1!=Integer.MAX_VALUE-1&&min2!=Integer.MAX_VALUE-1&&min2!=Integer.MAX_VALUE){
            return min1+min2;
        }
        return -1;
    }
}
