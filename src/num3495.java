public class num3495 {
    public long minOperations(int[][] queries) {
        long ans=0L;
        for(int[] query:queries){
            ans+=(calCost(query[0],query[1])+1)/2;
        }
        return ans;
    }
    public long calCost(int l,int r) {
        return cal(r)-cal(l-1)+r-l+1;
    }
    public long cal(int r) {
        long ans=0L;
        int level=1;
        int start=1;
        int mins=3;
        while (r>=(1<<(2*level))){
            ans+= (long) (level - 1) *mins;
            start=start<<2;
            mins=mins<<2;
            level++;
        }
        ans += (long) (level - 1) *(r-start+1);
        return ans;
    }
}
