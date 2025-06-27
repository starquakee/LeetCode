import java.util.Objects;

public class num392 {
    public boolean isSubsequence(String s, String t) {
        if(Objects.equals(s, ""))return true;
        int index=0;
        for(char ct:t.toCharArray()){
            if(s.charAt(index)==ct){
                index++;
                if(index==s.length())return true;
            }
        }
        return false;
    }
}
