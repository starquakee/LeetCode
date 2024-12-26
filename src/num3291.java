import java.util.Arrays;

public class num3291 {// target暂时的后缀与words的前缀匹配越多越好

    public int minValidStrings(String[] words, String target) {
        int n = target.length();
        int[] back = new int[n];
        for(String word:words){
            int[] pi = prefixFunction(word, target);
            for(int i=0;i<n;i++){
                back[i] = Math.max(back[i], pi[word.length()+1+i]);
            }
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE-100000);
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            dp[i] = Math.min(dp[i], dp[i-back[i-1]]+1);
            if (dp[i] > n) {
                return -1;
            }
        }
        return dp[n];
    }

    private int[] prefixFunction(String word, String target) {
        String s = word + "#" + target;
        int n = s.length();
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        return pi;
    }

}
