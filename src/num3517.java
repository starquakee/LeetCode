public class num3517 {
    public String smallestPalindrome(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (arr[i]>1) {
                while (arr[i]>1){
                    sb.append((char) (i + 'a'));
                    arr[i] -= 2;
                }
            }
        }
        for (int i=0;i<26;i++){
            if(arr[i]>0){
                sb.append((char)(i+'a'));
                arr[i]--;
                break;
            }
        }
        String ans = sb.toString();
        String ss = sb.reverse().substring(s.length()%2==0?0:1).toString();
        return ans+ss;
    }
}
