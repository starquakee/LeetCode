public class num2810 {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(chars[i]=='i'){
                sb.reverse();
            }else sb.append(chars[i]);
        }
        return sb.toString();
    }
}
