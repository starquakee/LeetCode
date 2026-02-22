public class num868 {
    public int binaryGap(int n) {
        int ans=0;
        String s = Integer.toBinaryString(n);
        int last=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') {
                if (last != -1) ans = Math.max(ans, i - last);
                last = i;
            }
        }
        return ans;
    }
}
