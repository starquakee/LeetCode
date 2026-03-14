import java.util.ArrayList;
import java.util.List;

public class num1415 {
    public String getHappyString(int n, int k) {
        List<StringBuilder> list = new ArrayList<>();
        backtrack(list, new StringBuilder(), n,k);
        if(k>list.size()) return "";
        return list.get(k-1).toString();
    }
    public void backtrack(List<StringBuilder> list, StringBuilder sb, int n, int k){
        if(list.size()>=k)return;
        if(sb.length()==n) {
            list.add(new StringBuilder(sb));
            return;
        }
        for(char c='a';c<='c';c++){
            if(sb.length()>0&&sb.charAt(sb.length()-1)==c) continue;
            sb.append(c);
            backtrack(list, sb, n,k);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
