import java.util.Arrays;

public class num2140 {
//    public long mostPoints(int[][] questions) {
//        int n= questions.length;
//        int[] arr = new int[n];
//        Arrays.fill(arr,-1);
//        for(int i=0;i<n;i++){
//            int index=questions[i][1];
//            if(i+index+1<n){
//                arr[i+index+1]=Math.max(i,arr[i+index+1]);
//            }
//            if(i>0)arr[i]=Math.max(arr[i],arr[i-1]);
//        }
//        long[] dp=new long[n];
//        dp[0]=questions[0][0];
//        for(int i=1;i<n;i++){
//            if(arr[i]==-1){
//                dp[i]=questions[i][0];
//                dp[i]=Math.max(dp[i-1],dp[i]);
//            }else {
//                dp[i]=Math.max(dp[i-1],dp[arr[i]]+questions[i][0]);
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(dp));
//        return dp[n-1];
//    }
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1]; // 解决每道题及以后题目的最高分数
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], questions[i][0] + dp[Math.min(n, i + questions[i][1] + 1)]);
        }
        return dp[0];
    }
}
