import java.util.Arrays;

public class num3121 {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int ans = 0;
        int[] last = new int[26];
        int[] first = new int[26];
        Arrays.fill(last,-1);
        Arrays.fill(first,-1);
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                last[c - 'a'] = i;
            } else {
                if(first[c - 'A'] == -1) {
                    first[c - 'A'] = i;
                }
            }
        }
        for(int i=0;i<26;i++){
            if(last[i]!=-1&&last[i]<first[i])ans++;
        }
        return ans;
    }
}
