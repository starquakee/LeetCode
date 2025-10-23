import java.util.ArrayList;
import java.util.List;

public class num3461 {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++) list.add(s.charAt(i)-'0');
        for(int i=n;i>2;i--){
            for(int j=0;j+1<i;j++){
                list.add((list.get(j)+list.get(j+1))%10);
            }
            list.subList(0, i).clear();
        }
        return list.get(0).equals(list.get(1));
    }
}
