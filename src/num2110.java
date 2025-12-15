public class num2110 {
    public long getDescentPeriods(int[] prices) {
        int n=prices.length;
        long ans=n;
        for(int i=0;i<n;i++){
            int count=1;
            for(int j=i+1;j<n;j++){
                if(prices[j]-prices[j-1]==-1){
                    ans+=count;
                    count++;
                    i++;
                }else {
                    break;
                }
            }
        }
        return ans;
    }
}
