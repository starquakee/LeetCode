import java.util.Objects;

public class num1404 {
    public int numSteps(String s) {
        int ans=0;
        while (!s.equals("1")){
            if(s.charAt(s.length()-1)=='0') s=even(s);
            else s=odd(s);
            ans++;
        }
        return ans;
    }
    public String even(String s){
        return s.substring(0,s.length()-1);
    }
    public String odd(String s){
        int n=s.length();
        int i=n-1;
        StringBuilder sb = new StringBuilder(s);
        while (i>=0&&s.charAt(i)=='1') {
            sb.setCharAt(i,'0');
            i--;
        }
        if(i>=0) sb.setCharAt(i,'1');
        else sb.insert(0,'1');
        return sb.toString();
    }
}
