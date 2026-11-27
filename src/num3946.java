public class num3946 {
    public int maximumSaleItems(int[][] items, int budget) {
        int[] f = new int[budget + 1];
        int mn = Integer.MAX_VALUE;
        for (int[] item : items) {
            int factor = item[0], price = item[1];
            mn = Math.min(mn, price);
            int cnt = 0;
            for (int[] other : items) {
                if (other[0] % factor == 0) {
                    cnt++;
                }
            }
            for (int j = budget; j >= price; j--) {
                f[j] = Math.max(f[j], f[j - price] + cnt);
            }
        }
        int ans = 0;
        for (int j = 0; j <= budget; j++) {
            ans = Math.max(ans, f[j] + (budget - j) / mn);
        }
        return ans;
    }
}
