public class num3021 {
    public long flowerGame(int n, int m) {
        long ans=0L;
        ans+= (long) ((n + 1) / 2) *(m/2);
        ans+= (long) (n/2)*((m+1)/2);
        return ans;
    }
}
