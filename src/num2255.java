public class num2255 {
    public int countPrefixes(String[] words, String s) {
        int ans=0;
        for(String word:words){
            if(s.startsWith(word))ans++;
        }
        return ans;
    }
}
