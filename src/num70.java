public class num70 {
//    public int climbStairs(int n) {
//        if(n==1) return 1;
//        if(n==2) return 2;
//        int[] dp = new int[n+1];
//        dp[1] = 1;
//        dp[2] = 2;
//        for(int i=3;i<=n;i++){
//            dp[i] = dp[i-2]+dp[i-1];
//        }
//        return dp[n];
//    }
//    public int climbStairs(int n) {
//        if(n==1)return 1;
//        if(n==2)return 2;
//        int[] dp = new int[n+1];
//        dp[1] = 1;
//        dp[2] = 2;
//        for(int i=3;i<=n;i++){
//            dp[i] = dp[i-2]+dp[i-1];
//        }
//        return dp[n];
//    }
    public int climbStairs(int n) {
        int num=Math.max(n+1,3);
        int[] dp = new int[num];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
