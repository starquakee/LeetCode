public class num1513 {
    public int numSub(String s) {
        int i=0;
        long ans=0;
        int MOD= (int) (1e9+7);
        while (i<s.length()){
            int count=0;
            while (i<s.length()&&s.charAt(i)=='0')i++;
            while (i<s.length()&&s.charAt(i)=='1'){
                i++;
                count++;
            }
            ans = (ans+(cal(count)%MOD))%MOD;
        }
        return (int)ans;
    }
    public long cal(int n){
        return (long)((long) n *(n+1)/2);
    }
}
