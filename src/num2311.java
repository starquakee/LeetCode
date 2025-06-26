public class num2311 {
    public int longestSubsequence(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int n=s.length();
        int sbIndex=0;
        for(int i=0;i<n;i++){
            if(compareBinaryStrings(Integer.toBinaryString(k),sb.toString())>=0)return sb.toString().length();
            if(s.charAt(i)=='1'){
                sb.deleteCharAt(sbIndex);
                continue;
            }
            sbIndex++;
        }
        return -1;
    }
    public static int compareBinaryStrings(String s1, String s2) {
        s1 = s1.replaceFirst("^0+", "");
        s2 = s2.replaceFirst("^0+", "");

        if (s1.length() != s2.length()) {
            return s1.length() - s2.length(); // 长度不同，长的更大
        }

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        return 0;
    }
}
