public class num1732 {
    public int largestAltitude(int[] gain) {
        int ans=0;
        int cur=0;
        for(int i=0;i<gain.length;i++) {
            cur += gain[i];
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
