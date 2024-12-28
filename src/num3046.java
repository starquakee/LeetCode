import java.util.HashMap;
import java.util.Map;

public class num3046 {
    //small dataset
//    public boolean isPossibleToSplit(int[] nums) {
//        int[] arr = new int[101];
//        for(int num:nums){
//            arr[num]++;
//            if(arr[num]>2)return false;
//        }
//        return true;
//    }

    //large dataset
    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num)>2)return false;
        }
        return true;
    }
}

