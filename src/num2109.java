public class num2109 {
    public String addSpaces(String s, int[] spaces) {
        if(spaces.length==0)return s;
        StringBuilder sb=new StringBuilder();
        sb.append(s, 0, spaces[0]);
        sb.append(" ");
        for(int i=0;i<spaces.length-1;i++){
            sb.append(s, spaces[i], spaces[i + 1]).append(" ");
        }
        sb.append(s.substring(spaces[spaces.length-1]));
        return sb.toString();
    }
}
