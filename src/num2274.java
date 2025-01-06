import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class num2274 {
//    public int maxConsecutive(int bottom, int top, int[] special) {
//        Arrays.sort(special);
//        int ans=0;
//        int index = 0;
//        int temp=0;
//        for(int i=bottom;i<=top;i++){
//            if(index>=special.length)temp++;
//            else {
//                if(i!=special[index])temp++;
//                else {
//                    ans = Math.max(ans,temp);
//                    temp=0;
//                    index++;
//                }
//            }
//        }
//        ans = Math.max(ans,temp);
//        return ans;
//    }

//    public int maxConsecutive(int bottom, int top, int[] special) {
//        Arrays.sort(special);
//        List<Integer> list = new ArrayList<>();
//        for(int i=1;i<special.length;i++){
//            list.add(special[i]-special[i-1]-1);
//        }
//        list.add(special[0]-bottom);
//        list.add(top-special[special.length-1]);
//        Collections.sort(list);
//        return list.get(list.size()-1);
//    }
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int ans = 0;
        ans = Math.max(ans, special[0]-bottom);
        ans = Math.max(ans, top-special[special.length-1]);
        for(int i=1;i<special.length;i++){
            ans = Math.max(ans, special[i]-special[i-1]-1);
        }
        return ans;
    }
}
