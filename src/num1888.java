public class num1888 {
    public int minFlips(String s) {
        s = s + s;
        int n = s.length();
        int ans = n;
        int evenOne = 0, oddOne = 0;
        int evenZero = 0, oddZero = 0;
        for(int i=0;i<n;i++) {
            if (s.charAt(i) == '1') {
                if (i % 2 == 0) evenOne++;
                else oddOne++;
            }else {
                if (i % 2 == 0) evenZero++;
                else oddZero++;
            }
            if (i >= n / 2) {
                if (s.charAt(i - n / 2) == '1') {
                    if ((i - n / 2) % 2 == 0) evenOne--;
                    else oddOne--;
                }else {
                    if ((i - n / 2) % 2 == 0) evenZero--;
                    else oddZero--;
                }
            }
            if(i>= n/2-1) {
                ans = Math.min(ans, evenZero + oddOne);
                ans = Math.min(ans, oddZero + evenOne);
            }
        }
        return ans;
    }
}
