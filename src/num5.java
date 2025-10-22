import java.util.Arrays;

public class num5 {
//    public static String longestPalindrome(String s) {
//        String ans = "";
//        for(int i=0;i<s.length();i++){
//            String a1 = check_medium(s,i);
//            String a2 = check_left(s,i);
//            String a;
//            if(a1.length()>=a2.length()){
//                a = a1;
//            }else a = a2;
//            System.out.println(a1+"!"+a2);
//            if(a.length()>ans.length()){
//                ans = a;
//            }
//        }
//        return ans;
//
//    }
//    public static String check_medium(String s, int i){//ji
//        int left = i-1;
//        int right = i+1;
//        if(left<0||right>=s.length()){
//            return s.substring(i,i+1);
//        }
//        while (left>=0&&right<s.length()){
//            if(s.charAt(left)==s.charAt(right)){
//                if(left>0&&right<s.length()-1){
//                    left--;
//                    right++;
//                }else break;
//            }else {
//                left++;
//                right--;
//                break;
//            }
//        }
//        System.out.println(left+" "+right);
//        return s.substring(left, right+1);
//    }
//    public static String check_left(String s, int i){//ou
//        int left = i;
//        int right = i+1;
//        if(right>=s.length()){
//            return "";
//        }
//        if(s.charAt(left)!=s.charAt(right)){
//            return "";
//        }
//        while (left>=0&&right<s.length()){
//            if(s.charAt(left)==s.charAt(right)){
//                if(left>0&&right<s.length()-1){
//                    left--;
//                    right++;
//                }else break;
//            }else {
//                left++;
//                right--;
//                break;
//            }
//        }
//        System.out.println(left+" "+right);
//        return s.substring(left, right+1);
//    }
    //expand around center
//    int start = 0;
//    int maxLen = 0;
//    public String longestPalindrome(String s) {
//        if(s.length()<=1) return s;
//        for(int i=0;i<s.length();i++){
//            checkPalindrome(s,i,i);
//            checkPalindrome(s,i,i+1);
//        }
//        return s.substring(start,start+maxLen);
//    }
//    public void checkPalindrome(String s,int l,int r){
//        while (l>=0 && r<s.length()&&s.charAt(l)==s.charAt(r)){
//            l--;
//            r++;
//        }
//        int len=r-l-1;
//        if(len>maxLen){
//            maxLen=len;
//            start=l+1;
//        }
//    }
    public String longestPalindrome(String s) {
        if(s.length()<=1) return s;
        int n = s.length();
        int start = 0;
        int maxLen = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i=0; i<n; i++){
            dp[i][i] = true;
            if(i+1<n&&s.charAt(i)==s.charAt(i+1)) dp[i][i+1] = true;
        }
        for(int L=3;L<=n;L++){
            for(int i=0;i+L-1<n;i++){
                int j = i+L-1;
                dp[i][j] = (s.charAt(i)==s.charAt(j))&&dp[i+1][j-1];
            }
        }
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(dp[i][j]&&j-i+1>maxLen){
                    maxLen = j-i+1;
                    start = i;
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
}
