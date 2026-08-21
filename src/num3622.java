public class num3622 {
    public boolean checkDivisibility(int n) {
        String s = String.valueOf(n);
        int sum=0;
        int ji=1;
        for(char c:s.toCharArray()){
            int temp=c-'0';
            sum+=temp;
            ji*=temp;
        }
        return n%(sum+ji)==0;
    }
}
