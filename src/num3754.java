public class num3754 {
    public long sumAndMultiply(int n) {
        String s=String.valueOf(n);
        long sum = 0;
        long x=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0') continue;
            sum+=s.charAt(i)-'0';
            x=x*10+s.charAt(i)-'0';
        }
        return sum*x;
    }
}
