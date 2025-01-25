public class num2412 {
    public long minimumMoney(int[][] transactions) {
        long ans=0;
        long allFail=0;
        for(int[] tran:transactions){
            int cost=tran[0];
            int cashback=tran[1];
            allFail+=Math.max(0,cost-cashback);
            if(cost>=cashback){
                ans = Math.max(ans, cashback);
            }else {
                ans = Math.max(ans, cost);
            }
        }
        return ans+allFail;
    }
}
