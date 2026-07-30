public class num3014 {
    public int minimumPushes(String word) {
        int n=word.length();
        if(n<=8)return n;
        if(n<=16) return 2*n-8;
        if(n<=24) return 3*n-24;
        return 4*n-48;
    }
}
