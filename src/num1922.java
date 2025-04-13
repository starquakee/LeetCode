public class num1922 {

    public int countGoodNumbers(long n) {
        long ans=0;
        long mod=1000000007L;
        if(n%2==0){
            return (int) power(20,n/2);
        }else return (int) (power(20,n/2)*5%mod);

    }
    public long power(long a, long n) {
        long mod=1000000007L;
        if (n == 0) return 1;
        long half = power(a, n / 2);
        if (n % 2 == 0) {
            return half * half %mod;
        } else {
            return half * half %mod * a %mod;
        }
    }
}
