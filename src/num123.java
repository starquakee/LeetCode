import java.util.Arrays;

public class num123 {
//    public int maxProfit(int[] prices) {
//        int n = prices.length;
//        int buy1 = -prices[0], sell1 = 0;
//        int buy2 = -prices[0], sell2 = 0;
//        for (int i = 1; i < n; ++i) {
//            buy1 = Math.max(buy1, -prices[i]);
//            sell1 = Math.max(sell1, buy1 + prices[i]);
//            buy2 = Math.max(buy2, sell1 - prices[i]);
//            sell2 = Math.max(sell2, buy2 + prices[i]);
//        }
//        return sell2;
//    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;
        right[n - 1] = 0;
        int lMin = Integer.MAX_VALUE;
        int rMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            lMin = Math.min(lMin, prices[i]);
            if(i>0) left[i] = Math.max(left[i-1], prices[i]-lMin);
        }
        for(int i=n-1;i>=0;i--){
            rMax = Math.max(rMax, prices[i]);
            if(i<n-1) right[i] = Math.max(right[i+1], rMax-prices[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, left[i]+right[i]);
        }
        return ans;
    }
}
