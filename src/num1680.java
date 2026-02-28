public class num1680 {
    public int concatenatedBinary(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(Integer.toBinaryString(i));
        }
        String s = sb.toString();
        int ans=0;
        for(int i=0;i<s.length();i++){
            ans=(int)(((long)ans<<1+(s.charAt(i)-'0'))%1000000007);
        }
        return ans;
    }
}
