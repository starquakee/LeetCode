import java.util.Arrays;
import java.util.List;

public class num624 {
//    public int maxDistance(List<List<Integer>> arrays) {
//        int ans=0;
//        int m=arrays.size();
//        int[] mins=new int[m];
//        int[] maxs=new int[m];
//        for(int i=0;i<m;i++){
//            mins[i]=arrays.get(i).get(0);
//            maxs[i]=arrays.get(i).get(arrays.get(i).size()-1);
//        }
//        if(m>10000){
//            int max=0;
//            int min=999999;
//            for(int num:mins){
//                max=Math.max(max,num);
//                min=Math.min(min,num);
//            }
//            return Math.abs(min-max);
//        }
//        for(int i=0;i<m;i++){
//            for(int j=0;j<m;j++){
//                if(i!=j) ans = Math.max(ans,Math.abs(mins[i]-maxs[j]));
//            }
//        }
//        return ans;
//    }
    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0;
        int n = arrays.get(0).size();
        int min_val = arrays.get(0).get(0);
        int max_val = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            n = arrays.get(i).size();
            res = Math.max(res, Math.max(Math.abs(arrays.get(i).get(n - 1) - min_val),
                    Math.abs(max_val - arrays.get(i).get(0))));
            min_val = Math.min(min_val, arrays.get(i).get(0));
            max_val = Math.max(max_val, arrays.get(i).get(n - 1));
        }
        return res;
    }
}
