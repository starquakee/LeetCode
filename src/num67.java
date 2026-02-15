public class num67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int n=Math.max(a.length(),b.length());
        int temp=0;
        for(int i=0;i<n;i++){
            if(i<a.length()){
                temp+=(a.charAt(a.length()-i-1)-'0');
            }
            if(i<b.length()){
                temp+=(b.charAt(b.length()-i-1)-'0');
            }
            sb.insert(0,temp%2);
            temp/=2;
        }
        if(temp==1)sb.insert(0,'1');
        return sb.toString();
    }
}
