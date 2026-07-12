import java.util.Arrays;
import java.util.Map;

public class num1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = arr.clone();
        Arrays.sort(arr);
        Map<Integer,Integer> map = new java.util.HashMap<>();
        int[] ans= new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],map.size()+1);
            }
        }
        for(int i=0;i<temp.length;i++){
            ans[i]=map.get(temp[i]);
        }
        return ans;
    }
}
