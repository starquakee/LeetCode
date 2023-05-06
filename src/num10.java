//public class num10 {
//    public static boolean isMatch(String s, String p) {
//        int left=0;
//        int right=0;
//        while (left<s.length()&&right<p.length()){
//            if(p.charAt(right)=='.'){
//                left++;
//                right++;
//            } else if (p.charAt(right) == '*') {
//                if(p.charAt(right-1)!='.'){
//                    while (s.charAt(left)==p.charAt(right-1)){
//                        left++;
//                        if(left==s.length()&&right==p.length()-1) return true;
//                    }
//                }else {//
//                    if (right==p.length()-1){
//                        return true;
//                    }else return false;
//                }
//
//            }else {
//                if(s.charAt(left)==p.charAt(right)){
//                    left++;
//                    right++;
//                }else return false;
//            }
//        }
//        if(left<s.length()||right<p.length())return false;
//        return true;
//    }
//    public static void main(String[] args) {
//        System.out.println(isMatch("aa","a"));
//
//    }
//}

import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Solution {
    public boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);

        return matcher.matches();
    }
}