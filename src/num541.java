public class num541 {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length()/(2*k)+1;i++){
            for(int j=Math.min(s.length()-1,i*2*k+k-1);j>=i*2*k;j--){
                sb.append(s.charAt(j));
            }
            for(int j=i*2*k+k;j<Math.min(s.length(),i*2*k+2*k);j++){
                sb.append(s.charAt(j));
            }
        }
        return sb.toString();
    }
}
