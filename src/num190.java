public class num190 {
    public int reverseBits(int n) {
        String num = Integer.toBinaryString(n);
        int ans=0;
        long pow=1L;
        for(int i=0;i<32-num.length();i++)pow*=2;
        for(int i=0;i<num.length();i++){
            ans+= (int) ((num.charAt(i)-'0')*pow);
            pow*=2;
        }
        return ans;
    }
}
