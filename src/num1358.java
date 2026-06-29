public class num1358 {
    public int numberOfSubstrings(String s) {
        int l=0,r=0,ans=0;
        int[] count = new int[3];
        while(r<s.length()) {
            count[s.charAt(r) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                ans += s.length() - r;
                count[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        return ans;
    }
}
