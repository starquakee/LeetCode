public class num3083 {
    public boolean isSubstringPresent(String s) {
        if(s.length()==1)return false;
        for(int i=s.length()-1;i>=1;i--){
            String reverse = new StringBuilder(s.substring(i-1,i+1)).reverse().toString();
            if(s.contains(reverse))return true;
        }
        return false;
    }
}
