import java.util.List;

public class num2273 {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new java.util.ArrayList<>();
        ans.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if(!compare(words[i],words[i-1])){
                ans.add(words[i]);
            }
        }
        return ans;
    }
    public boolean compare(String word1, String word2) {
        int[] f = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            f[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            f[word2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if(f[i] != 0) {return false;}
        }
        return true;
    }
}
