public class num2327 {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] newPeople = new long[n+1];
        int mod=1000_000_000+7;
        newPeople[0] = 1L;
        for (int i = 1; i <= n; i++) {
            for(int j = Math.max(0,i-forget+1); j <= i-delay; j++) {
                newPeople[i] += newPeople[j];
                newPeople[i] %= mod;
            }
        }
        long ans = 0L;
        for(int i=0;i<forget;i++) {
            ans+=newPeople[n-i-1];
            ans%=mod;
        }
        return (int)ans;
    }
}
