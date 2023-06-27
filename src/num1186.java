public class num1186 {
    public int maximumSum(int[] arr) {
        if(arr.length==0)return 0;
        if(arr.length==1)return arr[0];
        int[][] dp = new int[arr.length][2];
        dp[0][0] = arr[0];
        dp[0][1] = 0;
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],0)+arr[i];
            dp[i][1] = Math.max(dp[i-1][1]+arr[i],dp[i-1][0]);
            ans = Math.max(ans, dp[i][0]);
            ans = Math.max(ans, dp[i][1]);
        }
        return ans;
    }
}
