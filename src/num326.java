public class num326 {
    public boolean isPowerOfThree(int n) {
        if(n<=0) return false;
        long temp=1L;
        while (temp<n){
            temp=temp*3;
        }
        return temp==n;
    }
}
