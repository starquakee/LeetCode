import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderedStream {
    private String[] map;
    private int ptr;
    private final int maxPtr;

    public OrderedStream(int n) {
        map=new String[n+1];
        maxPtr=n;
        ptr=1;
    }

    public List<String> insert(int idKey, String value) {
        List<String> ans = new ArrayList<>();
        map[idKey]=value;
        while (ptr<=maxPtr&&map[ptr]!=null){
            ans.add(map[ptr]);
            ptr++;
        }
        return ans;
    }
}
