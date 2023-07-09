import java.util.ArrayList;
import java.util.List;

public class num131 {
    int[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    public List<List<String>> partition(String s) {
        f = new int[s.length()][s.length()];
        dfs(s,0);
        return ret;
    }
    public void dfs(String s,int i){
        if(i==s.length()) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for(int j=i;j<s.length();j++){
            if(isPar(s,i,j)==1){
                ans.add(s.substring(i,j+1));
                dfs(s,j+1);
                ans.remove(ans.size()-1);
            }
        }
    }
    public int isPar(String s,int begin,int end){
        if(f[begin][end]!=0)return f[begin][end];
        if(begin>=end){
            f[begin][end]=1;
            return f[begin][end];
        }
        if(isPar(s,begin+1,end-1)==1){
            if(s.charAt(begin)==s.charAt(end)){
                f[begin][end]=1;
                return f[begin][end];
            }
        }
        f[begin][end]=-1;
        return f[begin][end];
    }
}
