public class num1871 {
    public boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(s.length()-1)!='0')return false;
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int count = 0; // 当前位置前面有多少个位置可以跳到当前位置
        for(int i=minJump;i<n;i++) {
            if (dp[i - minJump]) count++;
            if (i > maxJump && dp[i - maxJump - 1]) count--;
            dp[i] = count > 0 && s.charAt(i) == '0';
        }
        return dp[n - 1];
    }
}
