public class num3838 {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            int sum = 0;
            for (char c : words[i].toCharArray()) {
                sum += weights[c - 'a'];
            }
            sb.append((char)('z' - sum % 26));
        }
        return sb.toString();
    }
}
