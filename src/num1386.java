import java.util.HashMap;
import java.util.Map;

public class num1386 {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,boolean[]> map = new HashMap<>();
        for(int[] res:reservedSeats){
            if(!map.containsKey(res[0]-1)) map.put(res[0]-1,new boolean[10]);
            map.get(res[0]-1)[res[1]-1]=true;
        }
        int ans=(n-map.size())*2;
        for(boolean[] temp:map.values()){
            if(!temp[1]&!temp[2]&!temp[3]&!temp[4]){
                temp[1]=true;
                temp[2]=true;
                temp[3]=true;
                temp[4]=true;
                ans++;
            }
            if(!temp[5]&!temp[6]&!temp[7]&!temp[8]){
                temp[5]=true;
                temp[6]=true;
                temp[7]=true;
                temp[8]=true;
                ans++;
            }
            if(!temp[3]&!temp[4]&!temp[5]&!temp[6]){
                temp[3]=true;
                temp[4]=true;
                temp[5]=true;
                temp[6]=true;
                ans++;
            }
        }
        return ans;
    }
}
