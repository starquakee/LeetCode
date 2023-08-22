import java.util.ArrayList;
import java.util.List;

public class num2337 {
    public boolean canChange(String start, String target) {
        int n = start.length();
        List<Integer> lStart = new ArrayList<>();
        List<Integer> rStart = new ArrayList<>();
        List<Integer> lTarget = new ArrayList<>();
        List<Integer> rTarget = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        for(int i=0;i<n;i++){
            char ss = start.charAt(i);
            char tt = target.charAt(i);
            if(ss=='L'){
                lStart.add(i);
                s.append("L");
            } else if (ss=='R') {
                rStart.add(i);
                s.append("R");
            }
            if(tt=='L'){
                lTarget.add(i);
                t.append("L");
            } else if (tt=='R') {
                rTarget.add(i);
                t.append("R");
            }
        }
        if(!s.toString().equals(t.toString()))return false;
        if(lStart.size()!=lTarget.size()||rStart.size()!=rTarget.size())return false;
        for(int i=0;i<lStart.size();i++){
            if(lStart.get(i)<lTarget.get(i))return false;
        }
        for(int i=0;i<rStart.size();i++){
            if(rStart.get(i)>rTarget.get(i))return false;
        }
        return true;
    }
}
