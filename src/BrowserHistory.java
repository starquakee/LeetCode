import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {
    int index;
    int maxLen;
    List<String> list;
    public BrowserHistory(String homepage) {
        index=0;
        maxLen=1;
        list=new ArrayList<>();
        list.add(homepage);
    }

    public void visit(String url) {
        list.add(index+1,url);
        index++;
        maxLen=index+1;
    }

    public String back(int steps) {
        int realStep=Math.min(steps,index);
        index-=realStep;
        return list.get(index);
    }

    public String forward(int steps) {
        int realStep=Math.min(maxLen-index-1,steps);
        index+=realStep;
        return list.get(index);
    }
}
