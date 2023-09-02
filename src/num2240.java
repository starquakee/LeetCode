public class num2240 {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        int max1 = total/cost1;
        for(int i=0;i<=max1;i++){
            ans += (total- (long) i *cost1)/cost2 +1;
        }
        return ans;
    }
}
