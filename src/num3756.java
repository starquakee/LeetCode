import static jdk.nashorn.internal.objects.NativeMath.pow;

public class num3756 {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int M = 1000000007;
        int[] ans = new int[queries.length];
        int[] prefixSum = new int[s.length() + 1];
        long[] prefixProduct = new long[s.length() + 1];
        int[] cnt = new int[s.length()+1];
        long[] pow10 = new long[100001];
        pow10[0] = 1;
        for (int i = 1; i < 100001; i++) {
            pow10[i] = (pow10[i-1] * 10) % M;
        }
        for(int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if(num == 0) {
                prefixSum[i + 1] = prefixSum[i];
                prefixProduct[i + 1] = prefixProduct[i];
                cnt[i + 1] = cnt[i];
                continue;
            }
            prefixSum[i + 1] = prefixSum[i] + num;
            prefixProduct[i + 1] = (prefixProduct[i] * 10 + num) % M;
            cnt[i + 1] = cnt[i] + 1;
        }
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int sum = prefixSum[r + 1] - prefixSum[l];
            long product = (long) ((prefixProduct[r + 1] - prefixProduct[l] * pow10[cnt[r+1]-cnt[l]] % M + M) % M);
            long temp = (long)sum%M * product % M;
            ans[i] = Math.toIntExact(temp);
        }
        return ans;
    }
}
