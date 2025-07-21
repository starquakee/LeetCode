public class num1957 {
    public String makeFancyString(String s) {
        if(s.length()<3)return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));
        for(int i=2;i<s.length();i++){
            if (s.charAt(i)==s.charAt(i-1)&&s.charAt(i-1)==s.charAt(i-2))continue;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
