public class num5 {
    public static String longestPalindrome(String s) {
        String ans = "";
        for(int i=0;i<s.length();i++){
            String a1 = check_medium(s,i);
            String a2 = check_left(s,i);
            String a;
            if(a1.length()>=a2.length()){
                a = a1;
            }else a = a2;
            System.out.println(a1+"!"+a2);
            if(a.length()>ans.length()){
                ans = a;
            }
        }
        return ans;

    }
    public static String check_medium(String s, int i){//ji
        int left = i-1;
        int right = i+1;
        if(left<0||right>=s.length()){
            return s.substring(i,i+1);
        }
        while (left>=0&&right<s.length()){
            if(s.charAt(left)==s.charAt(right)){
                if(left>0&&right<s.length()-1){
                    left--;
                    right++;
                }else break;
            }else {
                left++;
                right--;
                break;
            }
        }
        System.out.println(left+" "+right);
        return s.substring(left, right+1);
    }
    public static String check_left(String s, int i){//ou
        int left = i;
        int right = i+1;
        if(right>=s.length()){
            return "";
        }
        if(s.charAt(left)!=s.charAt(right)){
            return "";
        }
        while (left>=0&&right<s.length()){
            if(s.charAt(left)==s.charAt(right)){
                if(left>0&&right<s.length()-1){
                    left--;
                    right++;
                }else break;
            }else {
                left++;
                right--;
                break;
            }
        }
        System.out.println(left+" "+right);
        return s.substring(left, right+1);
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
