public class num1935 {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int ans=words.length;
        for (String word : words) {
            for (int j = 0; j < brokenLetters.length(); j++) {
                if (word.contains(brokenLetters.substring(j, j + 1))) {
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}
