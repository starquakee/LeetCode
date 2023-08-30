import java.util.Arrays;

public class num823 {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        long[] dp = new long[arr.length];
        long ans = 0;
        Arrays.fill(dp,1);
        for(int i=0;i<arr.length;i++){
            for(int first=0,second = i-1;first<=second;first++){
                while (second>=first&&(long)arr[first]*arr[second]>arr[i]){
                    second--;
                }
                if(second>=first&&(long)arr[first]*arr[second]==arr[i]){
                    int coe = 2;
                    if(first==second)coe=1;
                    dp[i] = (dp[i] + dp[first]*dp[second]*coe) % 1000_000_007;
                }
            }
            ans = (ans+dp[i])%1000_000_007;
        }
        return (int) ans;
    }
}
