import java.util.ArrayList;
import java.util.List;

public class num833 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int k = indices.length;
        String ans = s;
        int in = 0;
        List<Integer> ops = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ops.add(i);
        }
        ops.sort((i, j) -> indices[i] - indices[j]);
        for(int ii=0;ii<k;ii++){
            int i = ops.get(ii);
            if(indices[i]+sources[i].length()<=s.length()&&s.substring(indices[i], indices[i] + sources[i].length()).equals(sources[i])){
                String pre = ans.substring(0,indices[i]+in);
                String last = ans.substring(indices[i]+in+ sources[i].length());
                ans = pre+targets[i]+last;
                in += targets[i].length()-sources[i].length();
            }
        }
        return ans;
    }
}
