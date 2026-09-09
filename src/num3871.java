public class num3871 {
    public long countCommas(long n) {
        long ans=0L;
        int num=(getLen(n)-1)/3;
        for(int i=1;i<num;i++){
            ans+= (long) (i*(Math.pow(10,3*i+3)-Math.pow(10,3*i)));
        }
        return ans+= (long) ((n-Math.pow(10,3*num)+1)*num);
    }
    public int getLen(long n){
        String s=String.valueOf(n);
        return s.length();
    }
}
