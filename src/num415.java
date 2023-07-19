public class num415 {
    public String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        int maxLen = Math.max(num1.length(), num2.length());
        int len1 = num1.length();
        int len2 = num2.length();
        int carry = 0;
        for(int i=0;i<maxLen;i++){
            int a;
            int b;
            if(len1>i){
                a = num1.charAt(len1-i-1)-'0';
            }else a = 0;
            if(len2>i){
                b = num2.charAt(len2-i-1)-'0';
            }else b = 0;
            int sum = carry+a+b;
            ans.insert(0, sum % 10);
            carry = sum / 10;
        }
        if(carry==1) ans.insert(0, "1");
        return ans.toString();
    }
}
