import java.util.ArrayList;
import java.util.List;

public class num696 {
    public int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();
        int temp=1;
        while (temp<s.length()&&s.charAt(temp)==s.charAt(temp-1)){
            temp++;
        }
        list.add(temp);
        int len=1;
        temp++;
        if(temp<s.length()){
            while (temp<s.length()){
                if(s.charAt(temp)==s.charAt(temp-1)){
                    len++;
                }else {
                    list.add(len);
                    len=1;
                }
                temp++;
            }
            list.add(len);
        }else if(temp==s.length()) list.add(1);
        int ans=0;
        for(int i=1;i<list.size();i++){
            ans+=Math.min(list.get(i-1), list.get(i));
        }
        return ans;
    }
}
